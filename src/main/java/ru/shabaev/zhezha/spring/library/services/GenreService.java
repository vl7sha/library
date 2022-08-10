package ru.shabaev.zhezha.spring.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shabaev.zhezha.spring.library.models.Genre;
import ru.shabaev.zhezha.spring.library.repositories.GenreRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class GenreService {

    private final GenreRepository repository;

    @Autowired
    public GenreService(GenreRepository repository) {
        this.repository = repository;
    }

    public List<Genre> findAll(){
        return repository.findAll();
    }

    public Genre findOne(int id){
        Optional<Genre> foundEntity = repository.findById(id);
        return foundEntity.orElse(null);
    }

    @Transactional
    public void save(Genre entity){
        repository.save(entity);
    }

    @Transactional
    public void update(int id, Genre updatedEntity){
        updatedEntity.setId(id);
        repository.save(updatedEntity);
    }

    @Transactional
    public void delete(int id){
        repository.deleteById(id);
    }
}
