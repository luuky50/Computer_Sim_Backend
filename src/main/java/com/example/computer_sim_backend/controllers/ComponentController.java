package com.example.computer_sim_backend.controllers;

import com.example.computer_sim_backend.services.ComponentService;
import com.example.computer_sim_backend.entities.Component;
import com.example.computer_sim_backend.entities.enums.Type;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/components")
public class ComponentController {

    private final ComponentService componentService;

    public ComponentController(ComponentService componentService) {
        this.componentService = componentService;
    }

    @GetMapping()
    public List<Component> getComponents(){
        return this.componentService.getComponents();
    }


    @GetMapping("/{type}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Component> findComponentByType(@PathVariable String type){
        //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Type not found");
        return this.componentService.findComponentsByType(Arrays.stream(Type
                        .values())
                .filter(_type -> _type.toString()
                        .equals(type))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Type not found")));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Component addComponent(@RequestBody Component component){
        return this.componentService.addComponent(component);
    }
}
