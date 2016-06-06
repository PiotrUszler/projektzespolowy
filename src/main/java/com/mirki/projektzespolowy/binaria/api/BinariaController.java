package com.mirki.projektzespolowy.binaria.api;

import com.mirki.projektzespolowy.binaria.dto.BinariaDTO;
import com.mirki.projektzespolowy.binaria.service.IBinariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping(value = "/projektzespolowy/binaria")
public class BinariaController {

    @Autowired
    IBinariaService binariaService;

    @RequestMapping(value = "getById/{id}", method = RequestMethod.GET)
    public ResponseEntity<BinariaDTO> findBinariaById(@PathVariable("id") Long aId) {
        return new ResponseEntity<>(binariaService.findBinariaById(aId), HttpStatus.OK);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<BinariaDTO>> findAllBinaria() {
        return new ResponseEntity<>(binariaService.findAllBinaria(), HttpStatus.OK);
    }

    @RequestMapping(value = "/saveBinaria", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<BinariaDTO> saveBinaria(@RequestBody BinariaDTO aBinariaDTO) {
        return new ResponseEntity<>(binariaService.saveBinaria(aBinariaDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> deleteBinaria(@PathVariable("id") Long aId) {
        binariaService.deleteBinaria(aId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}