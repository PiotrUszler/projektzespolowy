package com.mirki.projektzespolowy.user.service;

import com.mirki.projektzespolowy.user.dto.UserDTO;

import java.util.List;


public interface IUserService {

    UserDTO findUserById(Long aId);

    List<UserDTO> findAllUsers();

    List<UserDTO> findUsersByFullName(String aName, String aLastName);

    UserDTO saveUser(UserDTO aUserDTO);

    UserDTO findUserByEmail(String aEmail);

    void deleteUser(Long aId);

    UserDTO logIn(String aEmail, String aPassword);
}
