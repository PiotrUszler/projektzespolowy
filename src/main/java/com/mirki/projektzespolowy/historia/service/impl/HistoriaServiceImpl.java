package com.mirki.projektzespolowy.historia.service.impl;

import com.mirki.projektzespolowy.historia.dto.HistoriaDTO;
import com.mirki.projektzespolowy.historia.ob.HistoriaOB;
import com.mirki.projektzespolowy.historia.repository.IHistoriaRepository;
import com.mirki.projektzespolowy.historia.service.IHistoriaService;
import com.mirki.projektzespolowy.user.dto.UserDTO;
import com.mirki.projektzespolowy.user.ob.UserOB;
import com.mirki.projektzespolowy.user.service.IUserService;
import com.mirki.projektzespolowy.util.converters.impl.HistoriaConverter;
import com.mirki.projektzespolowy.util.converters.impl.UserConverter;
import com.mirki.projektzespolowy.util.converters.impl.ZgloszenieConverter;
import com.mirki.projektzespolowy.util.wrappers.SaveHistoriaDTO;
import com.mirki.projektzespolowy.zgloszenie.dto.ZgloszenieDTO;
import com.mirki.projektzespolowy.zgloszenie.ob.ZgloszenieOB;
import com.mirki.projektzespolowy.zgloszenie.service.IZgloszenieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class HistoriaServiceImpl implements IHistoriaService{


    @Autowired
    IHistoriaRepository iHistoriaRepository;
    @Autowired
    HistoriaConverter historiaConverter;
    @Autowired
    IUserService userService;
    @Autowired
    UserConverter userConverter;
    @Autowired
    IZgloszenieService zgloszenieService;
    @Autowired
    ZgloszenieConverter zgloszenieConverter;



    @Override
    public HistoriaDTO findHistoriaById(Long aId) {
        HistoriaOB pHistoriaOB = iHistoriaRepository.findOne(aId);
        if (pHistoriaOB == null) {
            return null;
        }
        return historiaConverter.mapOBtoDTO(pHistoriaOB);
    }

    @Override
    public List<HistoriaDTO> findAllHistoria() {
        List<HistoriaDTO> pResult = new ArrayList<>();
        List<HistoriaOB> pHistoriaList = iHistoriaRepository.findAll();
        for (HistoriaOB historia : pHistoriaList) {
            pResult.add(historiaConverter.mapOBtoDTO(historia));
        }
        return pResult;
    }

    @Override
    public HistoriaDTO saveHistoria(SaveHistoriaDTO aWrapper) {
        HistoriaDTO pHistoriaDTO = aWrapper.getHistoria();
        ZgloszenieDTO pZgloszenieDTO = aWrapper.getZgloszenie();
        UserDTO pUserDTO = aWrapper.getUser();
        if (pZgloszenieDTO == null || pUserDTO == null || pHistoriaDTO == null) {
            return null;
        }
        HistoriaOB pHistoriaOB = iHistoriaRepository.findOne(pZgloszenieDTO.getId());
        if (pHistoriaOB == null) {
            UserOB pUserOB = userConverter.mapDTOtoOB(userService.findUserById(pUserDTO.getId()));
            ZgloszenieOB pZgloszenieOB = zgloszenieConverter.mapDTOtoOB(zgloszenieService.findZgloszenieById(pZgloszenieDTO.getId()));
            pHistoriaOB = historiaConverter.mapDTOtoOB(pHistoriaDTO);
            pHistoriaOB.setUser(pUserOB);
            pHistoriaOB.setZgloszenie(pZgloszenieOB);
            return historiaConverter.mapOBtoDTO(iHistoriaRepository.save(pHistoriaOB));
        }
        pHistoriaOB.setOpis(pHistoriaDTO.getOpis());
        pHistoriaOB.setTyp(pHistoriaDTO.getTyp());
        return historiaConverter.mapOBtoDTO(iHistoriaRepository.save(pHistoriaOB));
    }

    @Override
    public List<HistoriaDTO> findByUserId(Long aUserId) {
        List<HistoriaDTO> pResult = new ArrayList<>();
        List<HistoriaOB> pHistoriaList = iHistoriaRepository.findByUserId(aUserId);
        for (HistoriaOB historia : pHistoriaList) {
            pResult.add(historiaConverter.mapOBtoDTO(historia));
        }
        return pResult;
    }

    @Override
    public List<HistoriaDTO> findByZgloszenieId(Long aUserId) {
        List<HistoriaDTO> pResult = new ArrayList<>();
        List<HistoriaOB> pHistoriaList = iHistoriaRepository.findByZgloszenieId(aUserId);
        for (HistoriaOB historia : pHistoriaList) {
            pResult.add(historiaConverter.mapOBtoDTO(historia));
        }
        return pResult;
    }

    @Override
    public void deleteHistoria(Long aId) {
        iHistoriaRepository.delete(aId);
    }
}
