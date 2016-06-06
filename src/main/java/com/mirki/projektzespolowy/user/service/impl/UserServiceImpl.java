package com.mirki.projektzespolowy.user.service.impl;

import com.mirki.projektzespolowy.user.dto.UserDTO;
import com.mirki.projektzespolowy.user.ob.UserOB;
import com.mirki.projektzespolowy.user.repository.IUserRepository;
import com.mirki.projektzespolowy.user.service.IUserService;
import com.mirki.projektzespolowy.util.converters.impl.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    UserConverter userConverter;



    @Override
    public UserDTO findUserById(Long aId) {
        UserOB pUserOB = iUserRepository.findOne(aId);
        if (pUserOB == null) {
            return null;
        }
        return userConverter.mapOBtoDTO(pUserOB);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<UserDTO> pResult = new ArrayList<>();
        List<UserOB> pUserList = iUserRepository.findAll();
        for (UserOB user : pUserList) {
            pResult.add(userConverter.mapOBtoDTO(user));
        }
        return pResult;
    }


    @Override
    public List<UserDTO> findUsersByFullName(String aName, String aLastName) {
        List<UserDTO> pResult = new ArrayList<>();
        List<UserOB> pUserList = iUserRepository.findByFullName(aName, aLastName);
        for (UserOB user : pUserList) {
            pResult.add(userConverter.mapOBtoDTO(user));
        }
        return pResult;
    }

    @Override
    public UserDTO saveUser(UserDTO aUserDTO) {
        if (aUserDTO == null) {
            return null;
        }
        // sprawdzenie czy rekord juz istnieje
        UserOB pUserOB = aUserDTO.getId() == null ? null : iUserRepository.findOne(aUserDTO.getId());
        // zapis nowego
        if (pUserOB == null) {
            return userConverter.mapOBtoDTO(iUserRepository.save(userConverter.mapDTOtoOB(aUserDTO)));
        }
        // edycja istniejacego
        pUserOB.setImie(aUserDTO.getImie());
        pUserOB.setNazwisko(aUserDTO.getNazwisko());

        return userConverter.mapOBtoDTO(iUserRepository.save(pUserOB));
    }


    @Override
    public UserDTO findUserByEmail(String aEmail){
        UserOB user = iUserRepository.findByEmail(aEmail);
        if (user == null) {
            return null;
        }
        return userConverter.mapOBtoDTO(user);
    }

    @Override
    public void deleteUser(Long aId) {
        iUserRepository.delete(aId);
    }

    @Override
    public UserDTO logIn(String aEmail, String aPassword){
        UserDTO user = findUserByEmail(aEmail);
        UserOB userOB = userConverter.mapDTOtoOB(user);
        if(userOB.getPass().equals(aPassword)){
            return user;
        }
        return null;
    }

}
