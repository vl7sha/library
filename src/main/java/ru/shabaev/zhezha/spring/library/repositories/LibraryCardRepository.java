package ru.shabaev.zhezha.spring.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shabaev.zhezha.spring.library.models.LibraryCard;

@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCard, Integer> {
}
