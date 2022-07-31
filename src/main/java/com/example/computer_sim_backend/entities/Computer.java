package com.example.computer_sim_backend.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
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

    public void setId(int id) {
        this.id = id;
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



    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", name='" + name + '\'' +
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
