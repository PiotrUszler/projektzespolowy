package com.mirki.projektzespolowy.util.wrappers;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class ZapiszZgloszenieDTO {

    private long priorytet;
    private long projekt;
    private long user;
    private int zgloszenie;
    private int typ;
    private int status;
    private String opis;
}
