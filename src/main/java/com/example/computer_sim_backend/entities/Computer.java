package com.example.computer_sim_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "computer")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    @Column
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false)
    private Creator madeBy;

    @ManyToMany()
    private List<Component> components;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Creator getMadeBy() {
        return madeBy;
    }

    public List<Component> getComponents() {
        return components;
    }


    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", madeBy=" + madeBy +
                ", components=" + components +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return id == computer.id && name.equals(computer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
