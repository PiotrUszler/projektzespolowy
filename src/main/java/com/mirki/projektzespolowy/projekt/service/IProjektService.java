package com.mirki.projektzespolowy.projekt.service;

import com.mirki.projektzespolowy.projekt.dto.ProjektDTO;
import com.mirki.projektzespolowy.util.wrappers.ProjektAndUserDTO;

import java.util.List;


public interface IProjektService {

    ProjektDTO findProjektById(Long aId);

    List<ProjektDTO> findAllProjekty();

    ProjektDTO saveProjekt(ProjektDTO aProjektDTO);

    ProjektDTO addUserToProjekt(ProjektAndUserDTO aWrapper);

    List<ProjektDTO> findByUserId(Long aUserId);

    void deleteProjekt(Long aId);

}
