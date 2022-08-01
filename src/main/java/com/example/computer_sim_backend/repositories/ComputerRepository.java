package com.example.computer_sim_backend.repositories;

import com.example.computer_sim_backend.entities.Computer;
//import com.example.computer_sim_backend.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComputerRepository extends CrudRepository<Computer, Long> {
    List<Computer> findAllByName(String name);

    @Override
    List<Computer> findAll();

    Computer findById(long aLong);

    @Override
    <S extends Computer> S save(S entity);

    void deleteById(Long aLong);

    boolean existsById(Long aLong);

}
