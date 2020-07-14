package com.cenfotec.pomponio.service;

import com.cenfotec.pomponio.domain.Actor;
import com.cenfotec.pomponio.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
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

    public <T> List<T> findByAge(String range) {
        List<Actor> actorsInRange = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        LocalDate now1 = LocalDate.now();
        Period diff1;

        for (Actor actor:actorRepo.findAll()) {
            c.setTime(actor.getDateOfBirth());

            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH) + 1;
            int date = c.get(Calendar.DATE);
            LocalDate l1 = LocalDate.of(year, month, date);
            diff1 = Period.between(l1, now1);

            switch (range){
            case "20,30":
            	if(diff1.getYears()>=20 && diff1.getYears()<=30){
            	    actorsInRange.add(actor);
                }
            	
            	break;
            case "20":
                if(diff1.getYears()<20){
                    actorsInRange.add(actor);
                }
            	break;
            	
            case "40":
                if(diff1.getYears()>40){
                    actorsInRange.add(actor);
                }
            	break;
            case "30,40":
                if(diff1.getYears()>=30 && diff1.getYears()<=40){
                    actorsInRange.add(actor);
                }
                break;
            default:
            	break;

            }
        }
        return (List<T>) actorsInRange;

    }
}
