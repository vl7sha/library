package ru.shabaev.zhezha.spring.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shabaev.zhezha.spring.library.models.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
