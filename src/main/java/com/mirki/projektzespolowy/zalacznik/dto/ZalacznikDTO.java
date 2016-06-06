package com.mirki.projektzespolowy.zalacznik.dto;

import com.mirki.projektzespolowy.binaria.dto.BinariaDTO;
import com.mirki.projektzespolowy.historia.dto.HistoriaDTO;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class ZalacznikDTO implements Serializable {
    private Long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private String mimeType;
    private String nazwa;
    private BinariaDTO binaria;
    private HistoriaDTO historia;
}
