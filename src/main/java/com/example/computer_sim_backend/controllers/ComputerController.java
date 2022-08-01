package com.example.computer_sim_backend.controllers;

import com.example.computer_sim_backend.entities.Computer;
import com.example.computer_sim_backend.services.ComputerService;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{hashCode}")
    public Computer getComputerByHashCode(@PathVariable Integer hashCode){
        for (var item : this.computerService.getComputers()){
            if(item.hashCode() == hashCode){
                return this.computerService.getComputerById(item.getId());
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Computer with specified HashCode doesn't exist");
    }


    @GetMapping("/hash/{id}")
    public int getComputerHashCodeById(@PathVariable Integer id){
        return computerService.getComputerById(id).hashCode();
    }

    @PostMapping
    public Computer postComputer(@RequestBody Computer computer){
        return this.computerService.postNewComputer(computer);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComputerById(@PathVariable Long id){
        if(!this.computerService.computerExists(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Computer with specified ID doesn't exist");
        }
        this.computerService.deleteComputerById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Computer putComputerById(@PathVariable Long id, @RequestBody Computer computer){
        if(!this.computerService.computerExists(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Computer with specified id: " + id + " doesn't exist");
        }
        System.out.println(computer.toString());
        computer.setId(id);
        return this.computerService.putComputerById(computer);
    }
}
