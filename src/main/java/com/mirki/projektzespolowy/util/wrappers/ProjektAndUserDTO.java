package com.mirki.projektzespolowy.util.wrappers;

import com.mirki.projektzespolowy.projekt.dto.ProjektDTO;
import com.mirki.projektzespolowy.user.dto.UserDTO;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class ProjektAndUserDTO {
    private ProjektDTO projekt;
    private UserDTO user;
}
