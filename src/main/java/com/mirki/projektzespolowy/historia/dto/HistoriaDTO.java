package com.mirki.projektzespolowy.historia.dto;

import com.mirki.projektzespolowy.user.dto.UserDTO;
import com.mirki.projektzespolowy.util.enums.ETypKomentarza;
import com.mirki.projektzespolowy.zgloszenie.dto.ZgloszenieDTO;
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
public class HistoriaDTO implements Serializable {
    private Long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private String opis;
    private ETypKomentarza typ;
    private ZgloszenieDTO zgloszenie;
    private UserDTO user;
}
