package com.mirki.projektzespolowy.zalacznik.ob;

import com.mirki.projektzespolowy.binaria.ob.BinariaOB;
import com.mirki.projektzespolowy.historia.ob.HistoriaOB;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "zalaczniki")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_ZALACZNIK_ID")
public class ZalacznikOB{
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
    @Column(name="MIME_TYPE")
    private String mimeType;
    @Column(name="NAZWA")
    private String nazwa;
    @OneToOne
    private BinariaOB binaria;
    @ManyToOne
    private HistoriaOB historia;

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
