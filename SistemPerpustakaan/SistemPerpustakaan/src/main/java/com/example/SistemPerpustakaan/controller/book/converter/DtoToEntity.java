package com.example.SistemPerpustakaan.controller.book.converter;

import com.example.SistemPerpustakaan.model.dto.BookDto;
import com.example.SistemPerpustakaan.model.entity.Book;

public class DtoToEntity {

    public Book convertDtoToEntity(BookDto bookDto){
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setShelf(bookDto.getShelf());

        return book;
    }

}
