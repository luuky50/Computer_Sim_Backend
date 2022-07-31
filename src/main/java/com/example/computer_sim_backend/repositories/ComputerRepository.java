package com.example.computer_sim_backend.repositories;

import com.example.computer_sim_backend.entities.Computer;
//import com.example.computer_sim_backend.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ComputerRepository extends CrudRepository<Computer, Long> {
    List<Computer> findAllByName(String name);

    @Override
    List<Computer> findAll();

    Computer findById(Integer aLong);

    @Override
    <S extends Computer> S save(S entity);

    void deleteById(Integer aLong);

    boolean existsById(Integer aLong);
}
