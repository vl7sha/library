package ru.shabaev.zhezha.spring.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shabaev.zhezha.spring.library.models.Book;
import ru.shabaev.zhezha.spring.library.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book findOne(int id) {
        Optional<Book> foundEntity = repository.findById(id);
        return foundEntity.orElse(null);
    }

    public List<Book> searchByName(String name) {
        return repository.findByNameStartingWith(name);
    }

    @Transactional
    public void save(Book entity) {
        repository.save(entity);
    }

    @Transactional
    public void update(int id, Book updatedEntity) {
        updatedEntity.setId(id);
        repository.save(updatedEntity);
    }

    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }
}
