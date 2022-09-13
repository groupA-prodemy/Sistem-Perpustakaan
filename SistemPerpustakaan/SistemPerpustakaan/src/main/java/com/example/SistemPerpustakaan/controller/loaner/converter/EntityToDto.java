package com.example.SistemPerpustakaan.controller.loaner.converter;

import com.example.SistemPerpustakaan.model.dto.AdminDto;
import com.example.SistemPerpustakaan.model.dto.BookLoanerDto;
import com.example.SistemPerpustakaan.model.entity.Admin;
import com.example.SistemPerpustakaan.model.entity.BookLoaner;

public class EntityToDto {

    public BookLoanerDto convertEntityToDto(BookLoaner bookLoaner){
        BookLoanerDto bookLoanerDto = new BookLoanerDto();
        bookLoanerDto.setId(bookLoaner.getId());
        bookLoanerDto.setName(bookLoaner.getName());
        bookLoanerDto.setUsername(bookLoaner.getUsername());
        bookLoanerDto.setPassword(bookLoaner.getPassword());

        return bookLoanerDto;
    }
}
