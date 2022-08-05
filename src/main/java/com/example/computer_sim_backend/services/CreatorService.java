package com.example.computer_sim_backend.services;

import com.example.computer_sim_backend.entities.Creator;
import com.example.computer_sim_backend.repositories.CreatorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatorService {

    private final CreatorRepository creatorRepository;



    public CreatorService(CreatorRepository creatorRepository) {
        this.creatorRepository = creatorRepository;
    }


    public List<Creator> getCreators(){
        return this.creatorRepository.findAll();
    }

    public Creator postCreator(Creator creator){
        return this.creatorRepository.save(creator);
    }

    public boolean creatorExists(Long id) {
        return this.creatorRepository.existsById(id);
    }

    public Creator postCreatorById(Creator creator) {
        return this.creatorRepository.save(creator);
    }

    public void deleteCreatorById(Long id) {
        this.creatorRepository.deleteById(id);
    }
}
