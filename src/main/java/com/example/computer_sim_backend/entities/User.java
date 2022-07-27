package com.example.computer_sim_backend.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column
    private String name;

    @Column
    @OneToMany
    private List<Computer> computers;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //public List<Computer> getComputers() {
    //    return computers;
    //}
}

