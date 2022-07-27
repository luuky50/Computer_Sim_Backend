package com.example.computer_sim_backend.controllers;

import com.example.computer_sim_backend.entities.Computer;
import com.example.computer_sim_backend.services.ComputerService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/computers")
public class ComputerController {
    private final ComputerService computerService;

    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @GetMapping
    public List<Computer> getComputers(){
        return computerService.getComputers();
    }

    @PostMapping
    public Computer postComputer(@RequestBody Computer computer){
        return this.computerService.postNewComputer(computer);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComputerById(@PathVariable Integer id){
        if(!this.computerService.computerExists(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Computer with specified ID doesn't exist");
        }
        this.computerService.deleteComputerById(id);
    }

    @PutMapping("/{id}")
    public Computer putComputerById(@PathVariable Integer id, @RequestBody Computer computer){
        if(!this.computerService.computerExists(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Computer with specified ID doesn't exist");
        }
        if(!id.equals(computer.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Computer doesn't match with new id");
        }
        return this.computerService.putComputerById(computer);
    }
}
