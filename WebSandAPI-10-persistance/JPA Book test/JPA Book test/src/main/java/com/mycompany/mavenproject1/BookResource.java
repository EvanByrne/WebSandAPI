package com.mycompany.mavenproject1;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author manueltovaizquierdo
 */
@Path("/books")
public class BookResource {
    
    //===========================================
    //=         Attributes
    //===========================================
    
    BookService bookService = new BookService();        
    
    //===========================================
    //=         Constructor
    //===========================================
    
    public BookResource() {
    }
    
    //===========================================
    //=         REST API methods
    //===========================================

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Book> listBooks() {
        return bookService.retrieveBooks();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Book getBook(@PathParam("id") int id) {
        return bookService.retrieveBook(id);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Book saveBook(Book b) {
        return bookService.createBook(b);
    }
    
    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void removeBook(@PathParam("id") int id) {
        bookService.deleteBook(id);
    }
}
