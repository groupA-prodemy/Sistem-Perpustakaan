package com.example.SistemPerpustakaan.controller.book.crud;

import com.example.SistemPerpustakaan.controller.book.converter.DtoToEntity;
import com.example.SistemPerpustakaan.controller.book.converter.EntityToDto;
import com.example.SistemPerpustakaan.model.dto.BookDto;
import com.example.SistemPerpustakaan.model.dto.DefaultResponse;
import com.example.SistemPerpustakaan.model.entity.Book;
import com.example.SistemPerpustakaan.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    DtoToEntity dtoToEntity = new DtoToEntity();
    EntityToDto entityToDto = new EntityToDto();

    @GetMapping("/books")
    public List<BookDto> getListBook(){
        List<BookDto> list = new ArrayList<>();
        for(Book i: bookRepository.findAll()){
            list.add(entityToDto.convertEntityToDto(i));
        }
        return list;
    }

    @PostMapping("/addbook")
    public DefaultResponse<BookDto> addBook(@RequestBody BookDto bookDto){
        Book book = dtoToEntity.convertDtoToEntity(bookDto);
        DefaultResponse<BookDto> defaultResponse = new DefaultResponse<>();
        Optional<Book> optional = bookRepository.findByTitleAndShelf(bookDto.getTitle(), bookDto.getShelf());
        if(optional.isPresent()){
            defaultResponse.setStatus(Boolean.FALSE);
            defaultResponse.setMessage("Failed to save data, data was exists");
        }else{
            bookRepository.save(book);
            defaultResponse.setStatus(Boolean.TRUE);
            defaultResponse.setData(bookDto);
            defaultResponse.setMessage("Succeeded to save data");
        }
        return defaultResponse;
    }

    @DeleteMapping("/delete/{id}")
    public DefaultResponse deleteById(@PathVariable ("id") Integer id){
        DefaultResponse defaultResponse = new DefaultResponse();
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            bookRepository.delete(optionalBook.get());
            defaultResponse.setStatus(Boolean.TRUE);
            defaultResponse.setMessage("Succeeded delete data");
        }else{
            defaultResponse.setStatus(Boolean.FALSE);
            defaultResponse.setMessage("Failed to delete data, data was not found");
        }
        return defaultResponse;
    }

    @PutMapping("/update/{id}")
    public DefaultResponse updateById (@PathVariable Integer id, @RequestBody BookDto bookDto){
        DefaultResponse defaultResponse = new DefaultResponse();
        try{
            Optional<Book> optionalBook = bookRepository.findById(id);
            Book book = optionalBook.get();
            if (optionalBook.isPresent()){
                book.setTitle(bookDto.getTitle());
                book.setShelf(bookDto.getShelf());
                bookRepository.save(book);
                defaultResponse.setStatus(Boolean.TRUE);
                defaultResponse.setData(bookDto);
                defaultResponse.setMessage("Succeeded update data");
            }
        }catch(Exception e){
            defaultResponse.setStatus(Boolean.FALSE);
            defaultResponse.setMessage("Failed to update data, Id was not found");
        }
        return defaultResponse;
    }
}
