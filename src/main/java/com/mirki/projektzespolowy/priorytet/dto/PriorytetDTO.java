package com.mirki.projektzespolowy.priorytet.dto;

import com.mirki.projektzespolowy.util.enums.EJednostkaCzasu;
import com.mirki.projektzespolowy.util.enums.ETypPriorytetu;
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
public class PriorytetDTO implements Serializable {
    private Long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private ETypPriorytetu typ;
    private EJednostkaCzasu jednostka;
    private int ilosc;

}
