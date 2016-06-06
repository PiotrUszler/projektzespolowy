package com.mirki.projektzespolowy.priorytet.service;

import com.mirki.projektzespolowy.priorytet.dto.PriorytetDTO;

import java.util.List;


public interface IPriorytetService {

    PriorytetDTO findPriorytetById(Long aId);

    List<PriorytetDTO> findAllPriorytety();

    PriorytetDTO savePriorytet(PriorytetDTO aPriorytetDTO);

    void deletePriorytet(Long aId);
}
