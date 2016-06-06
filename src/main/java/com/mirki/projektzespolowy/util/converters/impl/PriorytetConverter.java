package com.mirki.projektzespolowy.util.converters.impl;

import com.mirki.projektzespolowy.priorytet.dto.PriorytetDTO;
import com.mirki.projektzespolowy.priorytet.ob.PriorytetOB;
import com.mirki.projektzespolowy.util.converters.AbstractConverter;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PriorytetConverter extends AbstractConverter<PriorytetOB, PriorytetDTO> {
    @Autowired
    public PriorytetConverter(Mapper mapper) {
        super(mapper, PriorytetOB.class, PriorytetDTO.class);
    }
}