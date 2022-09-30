package ru.shabaev.zhezha.spring.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.shabaev.zhezha.spring.library.models.Genre;
import ru.shabaev.zhezha.spring.library.repositories.GenreRepository;

@Service
@Transactional(readOnly = true)
public class GenreService {

    private final GenreRepository repository;

    @Autowired
    public GenreService(GenreRepository repository) {
        this.repository = repository;
    }

    public List<Genre> findAll() {
        return repository.findAll();
    }
    
    public Genre findOne(int id) {
        return repository.getReferenceById(id);
    }

    @Transactional
    public void save(Genre entity) {
        repository.save(entity);
    }

    @Transactional
    public void update(int id, Genre updatedEntity) {
        updatedEntity.setId(id);
        repository.save(updatedEntity);
    }

    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }
}
