package com.mirki.projektzespolowy.util.wrappers;

import com.mirki.projektzespolowy.historia.dto.HistoriaDTO;
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
public class SaveHistoriaDTO {
    private HistoriaDTO historia;
    private UserDTO user;
    private ZgloszenieDTO zgloszenie;
}
