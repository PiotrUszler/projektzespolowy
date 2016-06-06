package com.mirki.projektzespolowy.user.dto;

import com.mirki.projektzespolowy.util.enums.ETypUzytkownika;
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
public class UserDTO implements Serializable {
    private Long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private boolean aktywny;
    private String email;
    private String imie;
    private String nazwisko;
    private String password;
    private ETypUzytkownika typUzytkownika;

}
