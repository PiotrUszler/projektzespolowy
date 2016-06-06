package com.mirki.projektzespolowy.historia.repository;

import com.mirki.projektzespolowy.historia.ob.HistoriaOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IHistoriaRepository extends JpaRepository<HistoriaOB, Long> {
    @Query("SELECT  a FROM HistoriaOB a WHERE  a.user.id = ?1")
    List<HistoriaOB> findByUserId(Long aId);

    @Query("SELECT  a FROM HistoriaOB a WHERE  a.zgloszenie.id = ?1")
    List<HistoriaOB> findByZgloszenieId(Long aId);
}
