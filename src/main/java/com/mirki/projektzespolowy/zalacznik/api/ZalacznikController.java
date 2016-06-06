package com.mirki.projektzespolowy.zalacznik.api;

import com.mirki.projektzespolowy.util.wrappers.SaveZalacznikDTO;
import com.mirki.projektzespolowy.zalacznik.dto.ZalacznikDTO;
import com.mirki.projektzespolowy.zalacznik.service.IZalacznikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Transactional
@RequestMapping(value = "/projektzespolowy/zalaczniki")
public class ZalacznikController {
    @Autowired
    IZalacznikService zalacznikService;

    @RequestMapping(value = "getById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ZalacznikDTO> findZalacznikById(@PathVariable("id") Long aId) {
        return new ResponseEntity<>(zalacznikService.findZalacznikById(aId), HttpStatus.OK);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<ZalacznikDTO>> findAllZalacznik() {
        return new ResponseEntity<>(zalacznikService.findAllZalacznik(), HttpStatus.OK);
    }

    @RequestMapping(value = "getByUserId/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<ZalacznikDTO>> findZalacznikByHistoriaId(@PathVariable("historiaId") Long aHistoriaId) {
        return new ResponseEntity<>(zalacznikService.findByHistoriaId(aHistoriaId), HttpStatus.OK);
    }

    @RequestMapping(value = "/saveZalacznik", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<ZalacznikDTO> saveZalacznik(@RequestBody SaveZalacznikDTO aWrapper) {
        return new ResponseEntity<>(zalacznikService.saveZalacznik(aWrapper), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Void> deleteZalacznik(@PathVariable("id") Long aId) {
        zalacznikService.deleteZalacznik(aId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

