package ru.shabaev.zhezha.spring.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shabaev.zhezha.spring.library.models.BookCover;
import ru.shabaev.zhezha.spring.library.repositories.BookCoverRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookCoverService {

    private final BookCoverRepository repository;

    @Autowired
    public BookCoverService(BookCoverRepository repository) {
        this.repository = repository;
    }

    public List<BookCover> findAll(){
        return repository.findAll();
    }

    public BookCover findOne(int id){
        Optional<BookCover> foundEntity = repository.findById(id);
        return foundEntity.orElse(null);
    }

    @Transactional
    public void save(BookCover entity){
        repository.save(entity);
    }

    @Transactional
    public void update(int id, BookCover updatedEntity){
        updatedEntity.setId(id);
        repository.save(updatedEntity);
    }

    @Transactional
    public void delete(int id){
        repository.deleteById(id);
    }
}
