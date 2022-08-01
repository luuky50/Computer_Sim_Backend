package com.example.computer_sim_backend.controllers;

import com.example.computer_sim_backend.services.ComponentService;
import com.example.computer_sim_backend.entities.Component;
import com.example.computer_sim_backend.entities.enums.Type;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
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
    public Component postComponent(@RequestBody Component component){
        return this.componentService.addComponent(component);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Component putComponent(@PathVariable Long id, @RequestBody Component component){
        if(!this.componentService.componentExists(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Component with specified id: " + id + " doesn't exist");
        }
        component.setId(id);
        return this.componentService.postComponentById(component);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComponent(@PathVariable Long id){
        if(!this.componentService.componentExists(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Component with specified id: " + id + " doesn't exist");
        }
        this.componentService.deleteComponentById(id);
    }
}
