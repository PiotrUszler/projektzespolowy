package com.mirki.projektzespolowy.util.converters.impl;

import com.mirki.projektzespolowy.binaria.dto.BinariaDTO;
import com.mirki.projektzespolowy.binaria.ob.BinariaOB;
import com.mirki.projektzespolowy.util.converters.AbstractConverter;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BinariaConverter extends AbstractConverter<BinariaOB, BinariaDTO> {
    @Autowired
    public BinariaConverter(Mapper mapper) {
        super(mapper, BinariaOB.class, BinariaDTO.class);
    }
}
