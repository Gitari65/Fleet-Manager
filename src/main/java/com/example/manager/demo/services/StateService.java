package com.example.manager.demo.services;

import com.example.manager.demo.Repositories.StateRepository;
import com.example.manager.demo.models.Country;
import com.example.manager.demo.models.State;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;
    public List<State> getStates(){
        return stateRepository.findAll();
    }
    public void save(State state){
        stateRepository.save(state);
    }
public Optional<State> findById(@RequestParam Integer id){
        return stateRepository.findById(id);
}
public void delete(Integer id){
        stateRepository.deleteById(id);
}

}
