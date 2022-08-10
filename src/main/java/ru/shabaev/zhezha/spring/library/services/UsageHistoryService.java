package ru.shabaev.zhezha.spring.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shabaev.zhezha.spring.library.models.UsageHistory;
import ru.shabaev.zhezha.spring.library.repositories.UsageHistoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UsageHistoryService {

    private final UsageHistoryRepository repository;

    @Autowired
    public UsageHistoryService(UsageHistoryRepository repository) {
        this.repository = repository;
    }

    public List<UsageHistory> findAll(){
        return repository.findAll();
    }

    public UsageHistory findOne(int id){
        Optional<UsageHistory> foundEntity = repository.findById(id);
        return foundEntity.orElse(null);
    }

    @Transactional
    public void save(UsageHistory entity){
        repository.save(entity);
    }

    @Transactional
    public void update(int id, UsageHistory updatedEntity){
        updatedEntity.setId(id);
        repository.save(updatedEntity);
    }

    @Transactional
    public void delete(int id){
        repository.deleteById(id);
    }
}
