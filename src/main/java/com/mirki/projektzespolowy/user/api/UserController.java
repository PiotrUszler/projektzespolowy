package com.mirki.projektzespolowy.user.api;

import com.mirki.projektzespolowy.user.dto.UserDTO;
import com.mirki.projektzespolowy.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Transactional
@RequestMapping(value = "/projektzespolowy/users")
public class UserController {
    @Autowired
    IUserService userService;

    @RequestMapping(value = "getById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<UserDTO> findUserById(@PathVariable("id") Long aId) {
        return new ResponseEntity<>(userService.findUserById(aId), HttpStatus.OK);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getByFullNames/{name},{lastName}", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findUsersByNames(@PathVariable("name") String aName, @PathVariable("lastName") String aLastName) {
        return new ResponseEntity<>(userService.findUsersByFullName(aName, aLastName), HttpStatus.OK);
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO aUserDTO) {
        return new ResponseEntity<>(userService.saveUser(aUserDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/findByEmail/{email}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<UserDTO> findUserByEmail(@PathVariable("email") String aEmail){
        return new ResponseEntity<>(userService.findUserByEmail(aEmail), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long aId) {
        userService.deleteUser(aId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/login/{aEmail},{aPassword}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<UserDTO> login(@PathVariable("aEmail") String aEmail,@PathVariable("aPassword") String aPassword){
        return new ResponseEntity<>(userService.logIn(aEmail,aPassword), HttpStatus.OK);
    }

}
