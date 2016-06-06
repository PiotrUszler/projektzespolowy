package com.mirki.projektzespolowy.binaria.repository;

import com.mirki.projektzespolowy.binaria.ob.BinariaOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBinariaRepository extends JpaRepository<BinariaOB, Long> {
}
