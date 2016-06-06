package com.mirki.projektzespolowy.priorytet.ob;

import com.mirki.projektzespolowy.util.enums.EJednostkaCzasu;
import com.mirki.projektzespolowy.util.enums.ETypPriorytetu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "priorytety")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_PRIORYTET_ID")
public class PriorytetOB{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    private Long id;
    @Column(name = "DATA_UTWORZENIA", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dataUtworzenia;
    @Column(name = "DATA_MODYFIKACJI", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dataModyfikacji;
    @Column(name = "TYP")
    private ETypPriorytetu typ;
    @Column(name = "JEDNOSTKA")
    private EJednostkaCzasu jednostka;
    @Column(name = "ILOSC")
    private int ilosc;


    @PreUpdate
    private void setModDate() {
        dataModyfikacji = new Date();
    }

    @PrePersist
    private void setCreationDate(){
        dataModyfikacji = new Date();
        dataUtworzenia = new Date();
    }
}
