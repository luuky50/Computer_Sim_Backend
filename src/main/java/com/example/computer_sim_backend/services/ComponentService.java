package com.example.computer_sim_backend.services;

import com.example.computer_sim_backend.repositories.ComponentRepository;
import com.example.computer_sim_backend.entities.Component;
import com.example.computer_sim_backend.entities.enums.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentService {


    private final ComponentRepository componentRepository;



    public ComponentService(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }


    public List<Component> getComponents(){
        return this.componentRepository.findAll();
    }


    public List<Component> findComponentsByType(Type type){
        return this.componentRepository.findAllByType(type);

    }

    public Component addComponent(Component component){
        return this.componentRepository.save(component);
    }

}
