package com.example.computer_sim_backend.entities;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "computer")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

//    @NotNull
//    @OneToOne
//    private User madeBy;

    @ManyToMany()
    private List<Component> components;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    public User getMadeBy() {
//        return madeBy;
//    }

    public List<Component> getComponents() {
        return components;
    }
}
