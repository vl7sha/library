package ru.shabaev.zhezha.spring.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.shabaev.zhezha.spring.library.models.Author;
import ru.shabaev.zhezha.spring.library.repositories.AuthorRepository;

@Service
@Transactional(readOnly = true)
public class AuthorService {

    private final AuthorRepository repository;

    @Autowired
    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public List<Author> findAll() {
        return repository.findAll();
    }
    
    public Author findOne(int id) {
        return repository.getReferenceById(id);
    }

    @Transactional
    public void save(Author entity) {
        repository.save(entity);
    }

    @Transactional
    public void update(int id, Author updatedEntity) {
        updatedEntity.setId(id);
        repository.save(updatedEntity);
    }

    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }
}
