package ru.shabaev.zhezha.spring.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shabaev.zhezha.spring.library.models.BookPosition;
import ru.shabaev.zhezha.spring.library.repositories.BookPositionRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookPositionService {

    private final BookPositionRepository repository;

    @Autowired
    public BookPositionService(BookPositionRepository repository) {
        this.repository = repository;
    }

    public List<BookPosition> findAll(){
        return repository.findAll();
    }

    public BookPosition findOne(int id){
        Optional<BookPosition> foundEntity = repository.findById(id);
        return foundEntity.orElse(null);
    }

    @Transactional
    public void save(BookPosition entity){
        repository.save(entity);
    }

    @Transactional
    public void update(int id, BookPosition updatedEntity){
        updatedEntity.setId(id);
        repository.save(updatedEntity);
    }

    @Transactional
    public void delete(int id){
        repository.deleteById(id);
    }
}
