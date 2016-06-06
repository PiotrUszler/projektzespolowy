package com.mirki.projektzespolowy.util.converters.impl;

import com.mirki.projektzespolowy.util.converters.AbstractConverter;
import com.mirki.projektzespolowy.zalacznik.dto.ZalacznikDTO;
import com.mirki.projektzespolowy.zalacznik.ob.ZalacznikOB;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ZalacznikConverter extends AbstractConverter<ZalacznikOB, ZalacznikDTO> {
    @Autowired
    public ZalacznikConverter(Mapper mapper) {
        super(mapper, ZalacznikOB.class, ZalacznikDTO.class);
    }
}