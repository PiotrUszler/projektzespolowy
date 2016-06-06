package com.mirki.projektzespolowy;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Transactional
@RequestMapping(value = "/projektzespolowy/users")
public class Logowanie {

}
