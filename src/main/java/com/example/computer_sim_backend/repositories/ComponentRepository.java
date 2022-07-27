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

    @Override
    default <S extends Component> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    default Optional<Component> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    default boolean existsById(Long aLong) {
        return false;
    }

    List<Component> findAllByType(Type type);

    @Override
    default long count() {
        return 0;
    }

    @Override
    default void deleteById(Long aLong) {

    }

    @Override
    default void delete(Component entity) {

    }

    @Override
    default void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    default void deleteAll(Iterable<? extends Component> entities) {

    }

    @Override
    default void deleteAll() {

    }
}
