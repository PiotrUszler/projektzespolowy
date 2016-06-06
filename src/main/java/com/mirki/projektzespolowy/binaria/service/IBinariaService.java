package com.mirki.projektzespolowy.binaria.service;

import com.mirki.projektzespolowy.binaria.dto.BinariaDTO;

import java.util.List;


public interface IBinariaService {

    BinariaDTO findBinariaById(Long aId);

    List<BinariaDTO> findAllBinaria();

    BinariaDTO saveBinaria(BinariaDTO aBinariaDTO);

    void deleteBinaria(Long aId);
}
