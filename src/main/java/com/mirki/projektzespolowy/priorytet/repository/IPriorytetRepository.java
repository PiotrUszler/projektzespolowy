package com.mirki.projektzespolowy.priorytet.repository;

import com.mirki.projektzespolowy.priorytet.ob.PriorytetOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPriorytetRepository extends JpaRepository<PriorytetOB, Long> {
}
