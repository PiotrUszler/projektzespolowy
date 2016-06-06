package com.mirki.projektzespolowy.util.converters.impl;

import com.mirki.projektzespolowy.historia.dto.HistoriaDTO;
import com.mirki.projektzespolowy.historia.ob.HistoriaOB;
import com.mirki.projektzespolowy.util.converters.AbstractConverter;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HistoriaConverter extends AbstractConverter<HistoriaOB, HistoriaDTO> {
    @Autowired
    public HistoriaConverter(Mapper mapper) {
        super(mapper, HistoriaOB.class, HistoriaDTO.class);
    }
}