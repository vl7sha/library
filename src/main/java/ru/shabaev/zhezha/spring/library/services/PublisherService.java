package ru.shabaev.zhezha.spring.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shabaev.zhezha.spring.library.models.Publisher;
import ru.shabaev.zhezha.spring.library.repositories.PublisherRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PublisherService {

    private final PublisherRepository repository;

    @Autowired
    public PublisherService(PublisherRepository repository) {
        this.repository = repository;
    }

    public List<Publisher> findAll(){
        return repository.findAll();
    }

    public Publisher findOne(int id){
        Optional<Publisher> foundEntity = repository.findById(id);
        return foundEntity.orElse(null);
    }

    @Transactional
    public void save(Publisher entity){
        repository.save(entity);
    }

    @Transactional
    public void update(int id, Publisher updatedEntity){
        updatedEntity.setId(id);
        repository.save(updatedEntity);
    }

    @Transactional
    public void delete(int id){
        repository.deleteById(id);
    }
}
