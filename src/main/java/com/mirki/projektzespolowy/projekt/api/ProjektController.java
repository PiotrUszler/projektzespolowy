package com.mirki.projektzespolowy.projekt.api;

import com.mirki.projektzespolowy.projekt.dto.ProjektDTO;
import com.mirki.projektzespolowy.projekt.service.IProjektService;
import com.mirki.projektzespolowy.util.wrappers.ProjektAndUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Transactional
@RequestMapping(value = "/projektzespolowy/projekty")
public class ProjektController {
    @Autowired
    IProjektService projektService;

    @RequestMapping(value = "getById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ProjektDTO> findProjektById(@PathVariable("id") Long aId) {
        return new ResponseEntity<>(projektService.findProjektById(aId), HttpStatus.OK);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<ProjektDTO>> findAllProjekty() {
        return new ResponseEntity<>(projektService.findAllProjekty(), HttpStatus.OK);
    }

    @RequestMapping(value = "getByUserId/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<ProjektDTO>> findProjektyByUserId(@PathVariable("userId") Long aUserId) {
        return new ResponseEntity<>(projektService.findByUserId(aUserId), HttpStatus.OK);
    }

    @RequestMapping(value = "/saveProjekt", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<ProjektDTO> saveProjekt(@RequestBody ProjektDTO aProjektDTO) {
        return new ResponseEntity<>(projektService.saveProjekt(aProjektDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<ProjektDTO> addUserToProjekt(@RequestBody ProjektAndUserDTO aWrapper) {
        return new ResponseEntity<>(projektService.addUserToProjekt(aWrapper), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Void> deleteProjekt(@PathVariable("id") Long aId) {
        projektService.deleteProjekt(aId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
