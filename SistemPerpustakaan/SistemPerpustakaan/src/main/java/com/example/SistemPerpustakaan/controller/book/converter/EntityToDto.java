package com.example.SistemPerpustakaan.controller.book.converter;

import com.example.SistemPerpustakaan.model.dto.BookDto;
import com.example.SistemPerpustakaan.model.entity.Book;

public class EntityToDto {

    public BookDto convertEntityToDto(Book book){
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setShelf(book.getShelf());

        return bookDto;
    }

}
