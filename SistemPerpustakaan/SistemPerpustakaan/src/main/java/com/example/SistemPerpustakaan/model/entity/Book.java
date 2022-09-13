package com.example.SistemPerpustakaan.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_book")
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Id_Book_Seq")
    @SequenceGenerator(name="Id_Book_Seq",sequenceName="Id_Book_Seq",allocationSize=1)
    @Column(name = "t_id")
    private int id;
    @Column(name = "t_title")
    private String title;
    @Column (name = "t_shelf")
    private String shelf;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }
}
