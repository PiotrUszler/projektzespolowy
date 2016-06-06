package com.mirki.projektzespolowy.user.repository;

import com.mirki.projektzespolowy.user.ob.UserOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IUserRepository extends JpaRepository<UserOB, Long> {

    @Query("SELECT u FROM UserOB u WHERE u.imie = ?1 AND u.nazwisko = ?2")
    List<UserOB> findByFullName(String aName, String aLastName);

    @Query("SELECT user FROM UserOB user WHERE user.email = ?1")
    UserOB findByEmail(String aEmail);
}
