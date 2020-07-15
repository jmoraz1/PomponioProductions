package com.cenfotec.pomponio.service;

import com.cenfotec.pomponio.domain.Script;
import com.cenfotec.pomponio.repository.ScriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScriptService implements BaseService {
    @Autowired
    ScriptRepository scriptRepo;


    @Override
    public <T> T save(T newScript) {
        scriptRepo.save((Script)newScript);
        return newScript;
    }

    @Override
    public <T> T update(T script) {
        scriptRepo.save((Script)script);
        return script;
    }

    @Override
    public <T> T delete(T script) {
        scriptRepo.delete((Script)script);
        return script;
    }

    @Override
    public <T> List<T> getAll() {
        return (List<T>) scriptRepo.findAll();
    }

    public <T> List<T> findByName(String name) {

        return (List<T>) scriptRepo.findByName(name);
    }

    public <T> List<T> findByGenre(String genre) {

        return (List<T>) scriptRepo.findByGenre(genre);
    }
}
