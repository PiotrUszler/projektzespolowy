package com.mirki.projektzespolowy.historia.api;

import com.mirki.projektzespolowy.historia.dto.HistoriaDTO;
import com.mirki.projektzespolowy.historia.service.IHistoriaService;
import com.mirki.projektzespolowy.util.wrappers.SaveHistoriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Transactional
@RequestMapping(value = "/projektzespolowy/historia")
public class HistoriaController {
    @Autowired
    IHistoriaService historiaService;

    @RequestMapping(value = "getById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<HistoriaDTO> findHistoriaById(@PathVariable("id") Long aId) {
        return new ResponseEntity<>(historiaService.findHistoriaById(aId), HttpStatus.OK);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<HistoriaDTO>> findAllHistoria() {
        return new ResponseEntity<>(historiaService.findAllHistoria(), HttpStatus.OK);
    }

    @RequestMapping(value = "getByUserId/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<HistoriaDTO>> findHistoriaByUserId(@PathVariable("userId") Long aUserId) {
        return new ResponseEntity<>(historiaService.findByUserId(aUserId), HttpStatus.OK);
    }

    @RequestMapping(value = "getByZgloszenieId/{zgloszenieId}", method = RequestMethod.GET)
    public ResponseEntity<List<HistoriaDTO>> findZgloszeniaByProjektId(@PathVariable("zgloszenieId") Long aZgloszenieId) {
        return new ResponseEntity<>(historiaService.findByZgloszenieId(aZgloszenieId), HttpStatus.OK);
    }

    @RequestMapping(value = "/saveHistoria", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<HistoriaDTO> saveZgloszenie(@RequestBody SaveHistoriaDTO aWrapper) {
        return new ResponseEntity<>(historiaService.saveHistoria(aWrapper), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Void> deleteHistoria(@PathVariable("id") Long aId) {
        historiaService.deleteHistoria(aId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
