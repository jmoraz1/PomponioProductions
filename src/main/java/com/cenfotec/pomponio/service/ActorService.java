package com.cenfotec.pomponio.service;

import com.cenfotec.pomponio.domain.Actor;
import com.cenfotec.pomponio.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements BaseService {
    @Autowired
    ActorRepository actorRepo;


    @Override
    public <T> T save(T newActor) {
        actorRepo.save((Actor)newActor);
        return newActor;
    }

    @Override
    public <T> T update(T actor) {
        actorRepo.save((Actor)actor);
        return actor;
    }

    @Override
    public <T> T delete(T actor) {
        actorRepo.delete((Actor)actor);
        return actor;
    }

    @Override
    public <T> List<T> getAll() {
        return (List<T>) actorRepo.findAll();
    }

    public <T> List<T> findByGender(String gender) {

        return (List<T>) actorRepo.findByGender(gender);
    }
    public <T> List<T> findByName(String name) {

        return (List<T>) actorRepo.findByName(name);
    }
}
