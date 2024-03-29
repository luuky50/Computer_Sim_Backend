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
    @ResponseStatus(HttpStatus.OK)
    public List<Computer> getComputers(){
        return computerService.getComputers();
    }

    @GetMapping("/hashcode")
    @ResponseStatus(HttpStatus.OK)
    public Computer getComputerByHashCode(@RequestParam(name = "hashcode") Integer hashCode){
        for (var item : this.computerService.getComputers()){
            if(item.hashCode() == hashCode){
                return this.computerService.getComputerById(item.getId());
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Computer with specified HashCode doesn't exist");
    }


    @GetMapping("/hash")
    @ResponseStatus(HttpStatus.OK)
    public int getComputerHashCodeById(@RequestParam(name = "id") Integer id){
        if(computerService.getComputerById(id) == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Computer with specified ID doesn't exist");
        }
        return computerService.getComputerById(id).hashCode();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Computer postComputer(@RequestBody Computer computer){
        System.out.println(computer.getMadeBy());
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
    @ResponseStatus(HttpStatus.OK)
    public Computer putComputerById(@PathVariable Long id, @RequestBody Computer computer){
        if(!this.computerService.computerExists(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Computer with specified id: " + id + " doesn't exist");
        }
        System.out.println(computer.toString());
        computer.setId(id);
        return this.computerService.putComputerById(computer);
    }
}
