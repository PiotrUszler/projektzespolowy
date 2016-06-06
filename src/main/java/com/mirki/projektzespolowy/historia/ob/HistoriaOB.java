package com.mirki.projektzespolowy.historia.ob;

import com.mirki.projektzespolowy.user.ob.UserOB;
import com.mirki.projektzespolowy.util.enums.ETypKomentarza;
import com.mirki.projektzespolowy.zgloszenie.ob.ZgloszenieOB;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "historia")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_HISTORIA_ID")
public class HistoriaOB{
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
    @Column(name = "OPIS")
    private String opis;
    @Column(name = "TYP")
    private ETypKomentarza typ;
    @ManyToOne
    private ZgloszenieOB zgloszenie;
    @ManyToOne
    private UserOB user;

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
