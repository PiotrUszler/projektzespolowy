package com.mirki.projektzespolowy.util.converters.impl;

import com.mirki.projektzespolowy.projekt.dto.ProjektDTO;
import com.mirki.projektzespolowy.projekt.ob.ProjektOB;
import com.mirki.projektzespolowy.util.converters.AbstractConverter;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProjektConverter extends AbstractConverter<ProjektOB, ProjektDTO> {
    @Autowired
    public ProjektConverter(Mapper mapper) {
        super(mapper, ProjektOB.class, ProjektDTO.class);
    }
}