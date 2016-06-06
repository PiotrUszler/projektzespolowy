package com.mirki.projektzespolowy.historia.service;

import com.mirki.projektzespolowy.historia.dto.HistoriaDTO;
import com.mirki.projektzespolowy.util.wrappers.SaveHistoriaDTO;

import java.util.List;


public interface IHistoriaService {
    HistoriaDTO findHistoriaById(Long aId);

    List<HistoriaDTO> findAllHistoria();

    HistoriaDTO saveHistoria(SaveHistoriaDTO aWrapper);

    List<HistoriaDTO> findByUserId(Long aUserId);

    List<HistoriaDTO> findByZgloszenieId(Long aZgloszenieId);

    void deleteHistoria(Long aId);
}
