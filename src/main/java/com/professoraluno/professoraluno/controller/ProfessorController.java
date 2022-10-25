package com.professoraluno.professoraluno.controller;

import com.professoraluno.professoraluno.persistence.model.Professor;
import com.professoraluno.professoraluno.persistence.persistence.ProfessorRepository;
import com.professoraluno.professoraluno.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorRepository professorRepository;
    private final ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @PostMapping("/cadastrarProfessor")
    public ResponseEntity<?> cadastrarProfessor(@RequestBody Professor professor){
        return new ResponseEntity<>(professorRepository.save(professor), HttpStatus.OK);
    }

    @GetMapping("/mostrarProfessor")
    public ResponseEntity<?> MostrarProfessor(){
        return new ResponseEntity<>(professorRepository.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        professorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
