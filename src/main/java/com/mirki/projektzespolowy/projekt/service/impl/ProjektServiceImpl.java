package com.mirki.projektzespolowy.projekt.service.impl;

import com.mirki.projektzespolowy.projekt.dto.ProjektDTO;
import com.mirki.projektzespolowy.projekt.ob.ProjektOB;
import com.mirki.projektzespolowy.projekt.repository.IProjektRepository;
import com.mirki.projektzespolowy.projekt.service.IProjektService;
import com.mirki.projektzespolowy.user.repository.IUserRepository;
import com.mirki.projektzespolowy.user.service.IUserService;
import com.mirki.projektzespolowy.util.converters.impl.ProjektConverter;
import com.mirki.projektzespolowy.util.converters.impl.UserConverter;
import com.mirki.projektzespolowy.util.wrappers.ProjektAndUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class ProjektServiceImpl implements IProjektService {
    @Autowired
    IProjektRepository iProjektRepository;
    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    IUserService userService;
    @Autowired
    ProjektConverter projektConverter;
    @Autowired
    UserConverter userConverter;

    @Override
    public ProjektDTO findProjektById(Long aId){
        ProjektOB pProjektOB = iProjektRepository.findOne(aId);
        if(pProjektOB == null){
            return null;
        }
        return projektConverter.mapOBtoDTO(pProjektOB);
    }

    @Override
    public List<ProjektDTO> findAllProjekty(){
        List<ProjektDTO> pResult = new ArrayList<>();
        List<ProjektOB> pProjektList = iProjektRepository.findAll();
        for (ProjektOB projekt : pProjektList) {
            pResult.add(projektConverter.mapOBtoDTO(projekt));
        }
        return pResult;
    }

    @Override
    public List<ProjektDTO> findByUserId(Long aUserId){
        List<ProjektDTO> pResult = new ArrayList<>();
        List<ProjektOB> pProjektList = iProjektRepository.findByUserId(aUserId);
        for (ProjektOB schedule : pProjektList) {
            pResult.add(projektConverter.mapOBtoDTO(schedule));
        }
        return pResult;
    }

    @Override
    public ProjektDTO saveProjekt(ProjektDTO aProjektDTO){
        if(aProjektDTO == null){
            return null;
        }

        ProjektOB pProjektOB = aProjektDTO.getId() == null ? null : iProjektRepository.findOne(aProjektDTO.getId());

        if(pProjektOB == null){
            return projektConverter.mapOBtoDTO(iProjektRepository.save(projektConverter.mapDTOtoOB(aProjektDTO)));
        }

        pProjektOB.setNazwa(aProjektDTO.getNazwa());
        pProjektOB.setOpis(aProjektDTO.getOpis());
        pProjektOB.setWersja(aProjektDTO.getWersja());
        return projektConverter.mapOBtoDTO(pProjektOB);
    }



    @Override
    public ProjektDTO addUserToProjekt(ProjektAndUserDTO aWrapper){
        ProjektOB pProjektOB = iProjektRepository.findOne(aWrapper.getProjekt().getId());
        pProjektOB.getUsers().add(userConverter.mapDTOtoOB(userService.findUserById(aWrapper.getUser().getId())));
        return projektConverter.mapOBtoDTO(pProjektOB);
    }

    @Override
    public void deleteProjekt(Long aId){
        iProjektRepository.delete(aId);
    }
}
