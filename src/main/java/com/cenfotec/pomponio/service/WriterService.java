package com.cenfotec.pomponio.service;

import com.cenfotec.pomponio.domain.Writer;
import com.cenfotec.pomponio.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WriterService implements BaseService {
    @Autowired
    WriterRepository writerRepo;


    @Override
    public <T> T save(T newWriter) {
        writerRepo.save((Writer)newWriter);
        return newWriter;
    }

    @Override
    public <T> T update(T writer) {
        writerRepo.save((Writer)writer);
        return writer;
    }

    @Override
    public <T> T delete(T writer) {
        writerRepo.delete((Writer)writer);
        return writer;
    }

    @Override
    public <T> List<T> getAll() {
        return (List<T>) writerRepo.findAll();
    }
}
