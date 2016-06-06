package com.mirki.projektzespolowy.zalacznik.repository;

import com.mirki.projektzespolowy.zalacznik.ob.ZalacznikOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IZalacznikRepository extends JpaRepository<ZalacznikOB, Long> {
    @Query("SELECT  a FROM ZalacznikOB a WHERE  a.historia.id = ?1")
    List<ZalacznikOB> findByHistoriaId(Long aId);
}
