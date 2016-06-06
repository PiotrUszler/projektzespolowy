package com.mirki.projektzespolowy.util.converters.impl;

import com.mirki.projektzespolowy.user.dto.UserDTO;
import com.mirki.projektzespolowy.user.ob.UserOB;
import com.mirki.projektzespolowy.util.converters.AbstractConverter;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserConverter extends AbstractConverter<UserOB, UserDTO> {
    @Autowired
    public UserConverter(Mapper mapper) {
        super(mapper, UserOB.class, UserDTO.class);
    }
}
