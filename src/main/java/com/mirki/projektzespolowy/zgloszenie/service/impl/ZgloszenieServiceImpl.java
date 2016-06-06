package com.mirki.projektzespolowy.zgloszenie.service.impl;

import com.mirki.projektzespolowy.priorytet.dto.PriorytetDTO;
import com.mirki.projektzespolowy.priorytet.ob.PriorytetOB;
import com.mirki.projektzespolowy.priorytet.service.IPriorytetService;
import com.mirki.projektzespolowy.projekt.dto.ProjektDTO;
import com.mirki.projektzespolowy.projekt.ob.ProjektOB;
import com.mirki.projektzespolowy.projekt.service.IProjektService;
import com.mirki.projektzespolowy.user.dto.UserDTO;
import com.mirki.projektzespolowy.user.ob.UserOB;
import com.mirki.projektzespolowy.user.service.IUserService;
import com.mirki.projektzespolowy.util.converters.impl.PriorytetConverter;
import com.mirki.projektzespolowy.util.converters.impl.ProjektConverter;
import com.mirki.projektzespolowy.util.converters.impl.UserConverter;
import com.mirki.projektzespolowy.util.converters.impl.ZgloszenieConverter;
import com.mirki.projektzespolowy.util.enums.ETypPriorytetu;
import com.mirki.projektzespolowy.util.wrappers.SaveZgloszenieDTO;
import com.mirki.projektzespolowy.util.wrappers.ZapiszZgloszenieDTO;
import com.mirki.projektzespolowy.zgloszenie.dto.ZgloszenieDTO;
import com.mirki.projektzespolowy.zgloszenie.ob.ZgloszenieOB;
import com.mirki.projektzespolowy.zgloszenie.repository.IZgloszenieRepository;
import com.mirki.projektzespolowy.zgloszenie.service.IZgloszenieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class ZgloszenieServiceImpl implements IZgloszenieService {

    @Autowired
    IZgloszenieRepository iZgloszenieRepository;
    @Autowired
    ZgloszenieConverter zgloszenieConverter;
    @Autowired
    IUserService userService;
    @Autowired
    UserConverter userConverter;
    @Autowired
    IPriorytetService priorytetService;
    @Autowired
    PriorytetConverter priorytetConverter;
    @Autowired
    IProjektService projektService;
    @Autowired
    ProjektConverter projektConverter;


    @Override
    public ZgloszenieDTO findZgloszenieById(Long aId) {
        ZgloszenieOB pZgloszenieOB = iZgloszenieRepository.findOne(aId);
        if (pZgloszenieOB == null) {
            return null;
        }
        return zgloszenieConverter.mapOBtoDTO(pZgloszenieOB);
    }

    @Override
    public List<ZgloszenieDTO> findAllZgloszenia() {
        List<ZgloszenieDTO> pResult = new ArrayList<>();
        List<ZgloszenieOB> pZgloszenieList = iZgloszenieRepository.findAll();
        for (ZgloszenieOB zgloszenie : pZgloszenieList) {
            pResult.add(zgloszenieConverter.mapOBtoDTO(zgloszenie));
        }
        return pResult;
    }

    @Override
    public ZgloszenieDTO saveZgloszenie(SaveZgloszenieDTO aWrapper) {
        ZgloszenieDTO pZgloszenieDTO = aWrapper.getZgloszenie();
        UserDTO pUserDTO = aWrapper.getUser();
        PriorytetDTO pPriorytetDTO = aWrapper.getPriorytet();
        ProjektDTO pProjektDTO = aWrapper.getProjekt();
        if (pZgloszenieDTO == null || pUserDTO == null || pPriorytetDTO == null || pProjektDTO == null) {
            return null;
        }
        ZgloszenieOB pZgloszenieOB = iZgloszenieRepository.findOne(pZgloszenieDTO.getId());
        if (pZgloszenieOB == null) {
            UserOB pUserOB = userConverter.mapDTOtoOB(userService.findUserById(pUserDTO.getId()));
            PriorytetOB pPriorytetOB = priorytetConverter.mapDTOtoOB(priorytetService.findPriorytetById(pPriorytetDTO.getId()));
            ProjektOB pProjektOB = projektConverter.mapDTOtoOB(projektService.findProjektById(pProjektDTO.getId()));
            pZgloszenieOB = zgloszenieConverter.mapDTOtoOB(pZgloszenieDTO);
            pZgloszenieOB.setUser(pUserOB);
            pZgloszenieOB.setPriorytet(pPriorytetOB);
            pZgloszenieOB.setProjekt(pProjektOB);
            return zgloszenieConverter.mapOBtoDTO(iZgloszenieRepository.save(pZgloszenieOB));
        }
        pZgloszenieOB.setOpis(pZgloszenieDTO.getOpis());
        pZgloszenieOB.setStatus(pZgloszenieDTO.getStatus());
        pZgloszenieOB.setZgloszenieWewZew(pZgloszenieDTO.getZgloszenieWewZew());
        pZgloszenieOB.setTypZgloszenia(pZgloszenieDTO.getTypZgloszenia());
        return zgloszenieConverter.mapOBtoDTO(iZgloszenieRepository.save(pZgloszenieOB));
    }

    @Override
    public List<ZgloszenieDTO> findByUserId(Long aUserId) {
        List<ZgloszenieDTO> pResult = new ArrayList<>();
        List<ZgloszenieOB> pZgloszenieList = iZgloszenieRepository.findByUserId(aUserId);
        for (ZgloszenieOB zgloszenie : pZgloszenieList) {
            pResult.add(zgloszenieConverter.mapOBtoDTO(zgloszenie));
        }
        return pResult;
    }

    @Override
    public List<ZgloszenieDTO> findByProjektId(Long aUserId) {
        List<ZgloszenieDTO> pResult = new ArrayList<>();
        List<ZgloszenieOB> pZgloszenieList = iZgloszenieRepository.findByProjektId(aUserId);
        for (ZgloszenieOB zgloszenie : pZgloszenieList) {
            pResult.add(zgloszenieConverter.mapOBtoDTO(zgloszenie));
        }
        return pResult;
    }

    @Override
    public List<ZgloszenieDTO> findByPriorytetType(ETypPriorytetu aTypPriorytetu) {
        List<ZgloszenieDTO> pResult = new ArrayList<>();
        List<ZgloszenieOB> pZgloszenieList = iZgloszenieRepository.findByPriorytetType(aTypPriorytetu);
        for (ZgloszenieOB zgloszenie : pZgloszenieList) {
            pResult.add(zgloszenieConverter.mapOBtoDTO(zgloszenie));
        }
        return pResult;
    }

    @Override
    public void deleteZgloszenie(Long aId) {
        iZgloszenieRepository.delete(aId);
    }

    @Override
    public ZgloszenieDTO zapiszZgloszenie(ZapiszZgloszenieDTO zgloszenie){
        long user = zgloszenie.getUser();
        long priorytet = zgloszenie.getPriorytet();
        long projekt = zgloszenie.getProjekt();
        int zgloszeniee = zgloszenie.getZgloszenie();
        int typ = zgloszenie.getTyp();
        int status = zgloszenie.getStatus();
        String opis = zgloszenie.getOpis();
        ZgloszenieOB pZgloszenieOB = null;
        UserOB pUserOB = userConverter.mapDTOtoOB(userService.findUserById(user));
        PriorytetOB pPriorytetOB = priorytetConverter.mapDTOtoOB(priorytetService.findPriorytetById(priorytet));
        ProjektOB pProjektOB = projektConverter.mapDTOtoOB(projektService.findProjektById(projekt));
        pZgloszenieOB.setUser(pUserOB);
        pZgloszenieOB.setPriorytet(pPriorytetOB);
        pZgloszenieOB.setProjekt(pProjektOB);
        return zgloszenieConverter.mapOBtoDTO(iZgloszenieRepository.save(pZgloszenieOB));

    }
}
