package com.mirki.projektzespolowy.priorytet.api;

import com.mirki.projektzespolowy.priorytet.dto.PriorytetDTO;
import com.mirki.projektzespolowy.priorytet.service.IPriorytetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Transactional
@RequestMapping(value = "/projektzespolowy/priorytety")
public class PriorytetController {

    @Autowired
    IPriorytetService priorytetService;

    @RequestMapping(value = "getById/{id}", method = RequestMethod.GET)
    public ResponseEntity<PriorytetDTO> findPriorytetById(@PathVariable("id") Long aId) {
        return new ResponseEntity<>(priorytetService.findPriorytetById(aId), HttpStatus.OK);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<PriorytetDTO>> findAllPriorytety() {
        return new ResponseEntity<>(priorytetService.findAllPriorytety(), HttpStatus.OK);
    }

    @RequestMapping(value = "/savePriorytet", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<PriorytetDTO> savePriorytet(@RequestBody PriorytetDTO aPriorytetDTO) {
        return new ResponseEntity<>(priorytetService.savePriorytet(aPriorytetDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> deletePriorytet(@PathVariable("id") Long aId) {
        priorytetService.deletePriorytet(aId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
