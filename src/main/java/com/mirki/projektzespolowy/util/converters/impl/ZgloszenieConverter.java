package com.mirki.projektzespolowy.util.converters.impl;

import com.mirki.projektzespolowy.util.converters.AbstractConverter;
import com.mirki.projektzespolowy.zgloszenie.dto.ZgloszenieDTO;
import com.mirki.projektzespolowy.zgloszenie.ob.ZgloszenieOB;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ZgloszenieConverter extends AbstractConverter<ZgloszenieOB, ZgloszenieDTO> {
    @Autowired
    public ZgloszenieConverter(Mapper mapper) {
        super(mapper, ZgloszenieOB.class, ZgloszenieDTO.class);
    }
}