package com.example.computer_sim_backend.entities;

import com.example.computer_sim_backend.entities.enums.Type;
import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "component")
public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column
    @NotNull
    private String name;

    @Column
    private double price;


    public long getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
