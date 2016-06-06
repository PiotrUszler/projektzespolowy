package com.mirki.projektzespolowy.zalacznik.service;

import com.mirki.projektzespolowy.util.wrappers.SaveZalacznikDTO;
import com.mirki.projektzespolowy.zalacznik.dto.ZalacznikDTO;

import java.util.List;


public interface IZalacznikService {

    ZalacznikDTO findZalacznikById(Long aId);

    List<ZalacznikDTO> findAllZalacznik();

    ZalacznikDTO saveZalacznik(SaveZalacznikDTO aWrapper);

    List<ZalacznikDTO> findByHistoriaId(Long aHistoriaId);

    void deleteZalacznik(Long aId);
}
