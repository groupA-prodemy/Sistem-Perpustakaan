package com.example.SistemPerpustakaan.repository;

import com.example.SistemPerpustakaan.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByTitle(String title);

    Optional<Book> findByShelf(String shelf);

    Optional<Book> findByTitleAndShelf(String title, String shelf);
}
