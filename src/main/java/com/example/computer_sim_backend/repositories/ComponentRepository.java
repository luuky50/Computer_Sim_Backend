package com.example.computer_sim_backend.repositories;

import com.example.computer_sim_backend.entities.Component;
import com.example.computer_sim_backend.entities.enums.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComponentRepository extends CrudRepository<Component, Long> {

    @Override
    List<Component> findAll();

    @Override
    <S extends Component> S save(S entity);


    boolean existsById(Integer aLong);
    List<Component> findAllByType(Type type);

}
