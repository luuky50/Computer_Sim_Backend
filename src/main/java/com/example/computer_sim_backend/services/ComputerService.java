package com.example.computer_sim_backend.services;

import com.example.computer_sim_backend.entities.Computer;
import com.example.computer_sim_backend.repositories.ComputerRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ComputerService {

    private final EntityManager entityManager;

    private final ComputerRepository computerRepository;

    public ComputerService(EntityManager entityManager, ComputerRepository computerRepository) {
        this.entityManager = entityManager;
        this.computerRepository = computerRepository;
    }

    public List<Computer> getComputers(){
        return computerRepository.findAll();
    }

    public Computer getComputerById(long id){
        return computerRepository.findById(id);
    }


    public List<Computer> findComputersByName(String name){
        return this.computerRepository.findAllByName(name);
    }

    public Computer postNewComputer(Computer computer){
        return this.computerRepository.save(computer);
    }

    public void deleteComputerById(Long id){
        this.computerRepository.deleteById(id);
    }

    public boolean computerExists(Long id){
        return computerRepository.existsById(id);
    }

    public Computer putComputerById(Computer computer) {
        return this.computerRepository.save(computer);
    }
}
