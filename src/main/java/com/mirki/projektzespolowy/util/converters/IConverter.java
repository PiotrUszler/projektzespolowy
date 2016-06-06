package com.mirki.projektzespolowy.util.converters;


public interface IConverter<OB, DTO> {
    OB mapDTOtoOB(DTO dto);

    DTO mapOBtoDTO(OB ob);
}
