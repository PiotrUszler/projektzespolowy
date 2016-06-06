package com.mirki.projektzespolowy.binaria.service.impl;

import com.mirki.projektzespolowy.binaria.dto.BinariaDTO;
import com.mirki.projektzespolowy.binaria.ob.BinariaOB;
import com.mirki.projektzespolowy.binaria.repository.IBinariaRepository;
import com.mirki.projektzespolowy.binaria.service.IBinariaService;
import com.mirki.projektzespolowy.util.converters.impl.BinariaConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class BinariaServiceImpl implements IBinariaService {

    @Autowired
    IBinariaRepository iBinariaRepository;
    @Autowired
    BinariaConverter binariaConverter;

    @Override
    public BinariaDTO findBinariaById(Long aId) {
        BinariaOB pBinariaOB = iBinariaRepository.findOne(aId);
        if (pBinariaOB == null) {
            return null;
        }
        return binariaConverter.mapOBtoDTO(pBinariaOB);
    }

    @Override
    public List<BinariaDTO> findAllBinaria() {
        List<BinariaDTO> pResult = new ArrayList<>();
        List<BinariaOB> pBinariaList = iBinariaRepository.findAll();
        for (BinariaOB binaria : pBinariaList) {
            pResult.add(binariaConverter.mapOBtoDTO(binaria));
        }
        return pResult;
    }

    @Override
    public BinariaDTO saveBinaria(BinariaDTO aBinariaDTO) {
        if (aBinariaDTO == null) {
            return null;
        }
        BinariaOB pBinariaOB = aBinariaDTO.getId() == null ? null : iBinariaRepository.findOne(aBinariaDTO.getId());

        if (pBinariaOB == null) {
            return binariaConverter.mapOBtoDTO(iBinariaRepository.save(binariaConverter.mapDTOtoOB(aBinariaDTO)));
        }
        pBinariaOB.setBin(aBinariaDTO.getBin());
        return binariaConverter.mapOBtoDTO(iBinariaRepository.save(pBinariaOB));
    }

    @Override
    public void deleteBinaria(Long aId) {
        iBinariaRepository.delete(aId);
    }
}
