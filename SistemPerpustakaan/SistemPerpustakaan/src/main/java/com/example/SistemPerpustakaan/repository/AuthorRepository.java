package com.example.SistemPerpustakaan.repository;

import com.example.SistemPerpustakaan.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

Optional<Author> findByAuthorId (Integer authorId);


}
