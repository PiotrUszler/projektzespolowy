package com.mirki.projektzespolowy.util.wrappers;

import com.mirki.projektzespolowy.priorytet.dto.PriorytetDTO;
import com.mirki.projektzespolowy.projekt.dto.ProjektDTO;
import com.mirki.projektzespolowy.user.dto.UserDTO;
import com.mirki.projektzespolowy.zgloszenie.dto.ZgloszenieDTO;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class SaveZgloszenieDTO {
    private UserDTO user;
    private ZgloszenieDTO zgloszenie;
    private PriorytetDTO priorytet;
    private ProjektDTO projekt;
}
