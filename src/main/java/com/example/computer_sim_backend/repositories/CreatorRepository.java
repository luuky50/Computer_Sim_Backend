package com.example.computer_sim_backend.repositories;

import com.example.computer_sim_backend.entities.Creator;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CreatorRepository extends CrudRepository<Creator, Long> {

    <S extends Creator> S save(S entity);

    List<Creator> findAll();

    void deleteById(Long aLong);

}
