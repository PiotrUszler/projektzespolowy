package com.mirki.projektzespolowy.zgloszenie.repository;

import com.mirki.projektzespolowy.util.enums.ETypPriorytetu;
import com.mirki.projektzespolowy.zgloszenie.ob.ZgloszenieOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IZgloszenieRepository extends JpaRepository<ZgloszenieOB, Long> {
    @Query("SELECT  a FROM ZgloszenieOB a WHERE  a.user.id = ?1")
    List<ZgloszenieOB> findByUserId(Long aId);

    @Query("SELECT  a FROM ZgloszenieOB a WHERE  a.projekt.id = ?1")
    List<ZgloszenieOB> findByProjektId(Long aId);

    @Query("SELECT  a FROM ZgloszenieOB a WHERE  a.priorytet.typ = ?1")
    List<ZgloszenieOB> findByPriorytetType(ETypPriorytetu typPriorytetu);

}
