package ru.shabaev.zhezha.spring.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shabaev.zhezha.spring.library.models.LibraryCard;
import ru.shabaev.zhezha.spring.library.repositories.LibraryCardRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class LibraryCardService {

    private final LibraryCardRepository repository;

    @Autowired
    public LibraryCardService(LibraryCardRepository repository) {
        this.repository = repository;
    }

    public List<LibraryCard> findAll(){
        return repository.findAll();
    }

    public LibraryCard findOne(int id){
        Optional<LibraryCard> foundEntity = repository.findById(id);
        return foundEntity.orElse(null);
    }

    @Transactional
    public void save(LibraryCard entity){
        repository.save(entity);
    }

    @Transactional
    public void update(int id, LibraryCard updatedEntity){
        updatedEntity.setId(id);
        repository.save(updatedEntity);
    }

    @Transactional
    public void delete(int id){
        repository.deleteById(id);
    }
}
