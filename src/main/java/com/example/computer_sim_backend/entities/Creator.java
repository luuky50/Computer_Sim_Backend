package com.example.computer_sim_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "creator")
public class Creator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column
    private String name;

    @Column(columnDefinition="text", length=1000)
    private String description;

    @Column
    @OneToMany
    @JsonIgnore
    private List<Computer> computers;

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public List<Computer> getComputers() {
        return computers;
    }

    public void setId(long id) {
        this.id = id;
    }
}

