package com.example.computer_sim_backend.repositories;

import com.example.computer_sim_backend.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

}
