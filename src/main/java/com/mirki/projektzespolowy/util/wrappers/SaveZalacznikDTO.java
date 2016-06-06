package com.mirki.projektzespolowy.util.wrappers;

import com.mirki.projektzespolowy.binaria.dto.BinariaDTO;
import com.mirki.projektzespolowy.historia.dto.HistoriaDTO;
import com.mirki.projektzespolowy.zalacznik.dto.ZalacznikDTO;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class SaveZalacznikDTO {
    private ZalacznikDTO zalacznik;
    private BinariaDTO binaria;
    private HistoriaDTO historia;
}
