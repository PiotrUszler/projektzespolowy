package com.mirki.projektzespolowy.zgloszenie.service;

import com.mirki.projektzespolowy.util.enums.ETypPriorytetu;
import com.mirki.projektzespolowy.util.wrappers.SaveZgloszenieDTO;
import com.mirki.projektzespolowy.util.wrappers.ZapiszZgloszenieDTO;
import com.mirki.projektzespolowy.zgloszenie.dto.ZgloszenieDTO;

import java.util.List;


public interface IZgloszenieService {

    ZgloszenieDTO findZgloszenieById(Long aId);

    List<ZgloszenieDTO> findAllZgloszenia();

    ZgloszenieDTO saveZgloszenie(SaveZgloszenieDTO aWrapper);

    List<ZgloszenieDTO> findByUserId(Long aUserId);

    List<ZgloszenieDTO> findByProjektId(Long aProjektId);

    List<ZgloszenieDTO> findByPriorytetType(ETypPriorytetu aTypPriorytetu);

    void deleteZgloszenie(Long aId);

    ZgloszenieDTO zapiszZgloszenie(ZapiszZgloszenieDTO aZgloszenie);
}
