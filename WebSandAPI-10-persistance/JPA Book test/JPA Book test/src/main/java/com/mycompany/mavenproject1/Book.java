package com.mycompany.mavenproject1;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manueltovaizquierdo
 */

@Entity
@Table
@XmlRootElement
public class Book implements Serializable {   
    //===========================================
    //=         Attributes
    //===========================================

    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String title;
    private String author;
    private String publisher;

    //===========================================
    //=         Constructors
    //===========================================

    public Book() {
    }

    public Book(int id, String title, String author, String publisher) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    //===========================================
    //=         Getters & Setters
    //===========================================
    
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    
}
