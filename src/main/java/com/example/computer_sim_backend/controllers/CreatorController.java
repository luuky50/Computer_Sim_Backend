package com.example.computer_sim_backend.controllers;

import com.example.computer_sim_backend.entities.Creator;
import com.example.computer_sim_backend.services.CreatorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/creators")
public class CreatorController {
    private final CreatorService creatorService;

    public CreatorController(CreatorService creatorService) {
        this.creatorService = creatorService;
    }

    @GetMapping()
    public List<Creator> getCreators(){
        return this.creatorService.getCreators();
    }


    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Creator> findCreatorByName(@PathVariable String name){
        //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Type not found");
        return this.creatorService.findCreatorByName(name);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Creator postCreator(@RequestBody Creator creator){
        return this.creatorService.postCreator(creator);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Creator putCreator(@PathVariable Long id, @RequestBody Creator creator){
        if(!this.creatorService.creatorExists(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Creator with specified id: " + id + " doesn't exist");
        }
        creator.setId(id);
        return this.creatorService.postCreator(creator);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCreator(@PathVariable Long id){
        if(!this.creatorService.creatorExists(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Creator with specified id: " + id + " doesn't exist");
        }
        this.creatorService.deleteCreatorById(id);
    }
}
