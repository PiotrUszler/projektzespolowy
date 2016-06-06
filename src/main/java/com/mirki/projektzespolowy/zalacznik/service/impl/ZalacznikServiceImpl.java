package com.mirki.projektzespolowy.zalacznik.service.impl;

import com.mirki.projektzespolowy.binaria.dto.BinariaDTO;
import com.mirki.projektzespolowy.binaria.ob.BinariaOB;
import com.mirki.projektzespolowy.binaria.service.IBinariaService;
import com.mirki.projektzespolowy.historia.dto.HistoriaDTO;
import com.mirki.projektzespolowy.historia.ob.HistoriaOB;
import com.mirki.projektzespolowy.historia.service.IHistoriaService;
import com.mirki.projektzespolowy.util.converters.impl.BinariaConverter;
import com.mirki.projektzespolowy.util.converters.impl.HistoriaConverter;
import com.mirki.projektzespolowy.util.converters.impl.ZalacznikConverter;
import com.mirki.projektzespolowy.util.wrappers.SaveZalacznikDTO;
import com.mirki.projektzespolowy.zalacznik.dto.ZalacznikDTO;
import com.mirki.projektzespolowy.zalacznik.ob.ZalacznikOB;
import com.mirki.projektzespolowy.zalacznik.repository.IZalacznikRepository;
import com.mirki.projektzespolowy.zalacznik.service.IZalacznikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class ZalacznikServiceImpl implements IZalacznikService {

    @Autowired
    IZalacznikRepository iZalacznikRepository;
    @Autowired
    ZalacznikConverter zalacznikConverter;
    @Autowired
    IHistoriaService historiaService;
    @Autowired
    HistoriaConverter historiaConverter;
    @Autowired
    IBinariaService binariaService;
    @Autowired
    BinariaConverter binariaConverter;




    @Override
    public ZalacznikDTO findZalacznikById(Long aId) {
        ZalacznikOB pZalacznikOB = iZalacznikRepository.findOne(aId);
        if (pZalacznikOB == null) {
            return null;
        }
        return zalacznikConverter.mapOBtoDTO(pZalacznikOB);
    }

    @Override
    public List<ZalacznikDTO> findAllZalacznik() {
        List<ZalacznikDTO> pResult = new ArrayList<>();
        List<ZalacznikOB> pZalacznikList = iZalacznikRepository.findAll();
        for (ZalacznikOB zalacznik : pZalacznikList) {
            pResult.add(zalacznikConverter.mapOBtoDTO(zalacznik));
        }
        return pResult;
    }

    @Override
    public ZalacznikDTO saveZalacznik(SaveZalacznikDTO aWrapper) {
        ZalacznikDTO pZalacznikDTO = aWrapper.getZalacznik();
        HistoriaDTO pHistoriaDTO = aWrapper.getHistoria();
        BinariaDTO pBinariaDTO = aWrapper.getBinaria();
        if (pZalacznikDTO == null || pBinariaDTO == null || pHistoriaDTO == null) {
            return null;
        }
        ZalacznikOB pZalacznikOB = iZalacznikRepository.findOne(pZalacznikDTO.getId());
        if (pZalacznikOB == null) {
            HistoriaOB pHistoriaOB = historiaConverter.mapDTOtoOB(historiaService.findHistoriaById(pHistoriaDTO.getId()));
            BinariaOB pBinariaOB = binariaConverter.mapDTOtoOB(binariaService.findBinariaById(pBinariaDTO.getId()));
            pZalacznikOB = zalacznikConverter.mapDTOtoOB(pZalacznikDTO);
            pZalacznikOB.setHistoria(pHistoriaOB);
            pZalacznikOB.setBinaria(pBinariaOB);
            return zalacznikConverter.mapOBtoDTO(iZalacznikRepository.save(pZalacznikOB));
        }
        pZalacznikOB.setNazwa(pZalacznikDTO.getNazwa());
        pZalacznikOB.setMimeType(pZalacznikDTO.getMimeType());
        return zalacznikConverter.mapOBtoDTO(iZalacznikRepository.save(pZalacznikOB));
    }


    @Override
    public List<ZalacznikDTO> findByHistoriaId(Long aHistoriaId) {
        List<ZalacznikDTO> pResult = new ArrayList<>();
        List<ZalacznikOB> pZalacznikList = iZalacznikRepository.findByHistoriaId(aHistoriaId);
        for (ZalacznikOB zalacznik : pZalacznikList) {
            pResult.add(zalacznikConverter.mapOBtoDTO(zalacznik));
        }
        return pResult;
    }

    @Override
    public void deleteZalacznik(Long aId) {
        iZalacznikRepository.delete(aId);
    }
}
