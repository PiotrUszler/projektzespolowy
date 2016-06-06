package com.mirki.projektzespolowy.zgloszenie.dto;

import com.mirki.projektzespolowy.priorytet.dto.PriorytetDTO;
import com.mirki.projektzespolowy.projekt.dto.ProjektDTO;
import com.mirki.projektzespolowy.user.dto.UserDTO;
import com.mirki.projektzespolowy.util.enums.EStatusZgloszenia;
import com.mirki.projektzespolowy.util.enums.ETypZgloszenia;
import com.mirki.projektzespolowy.util.enums.EZgloszenieWewZew;
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
public class ZgloszenieDTO implements Serializable {
    private Long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private String opis;
    private PriorytetDTO priorytet;
    private ProjektDTO projekt;
    private EStatusZgloszenia status;
    private ETypZgloszenia typZgloszenia;
    private EZgloszenieWewZew zgloszenieWewZew;
    private UserDTO user;
}
