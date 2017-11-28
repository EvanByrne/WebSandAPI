package com.mycompany.mavenproject1;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author manueltovaizquierdo
 */

public class BookService {
    
    //===========================================
    //=         Attributes
    //===========================================
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Book");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();        
    
    
    //===========================================
    //=         Public methods
    //===========================================

    public List<Book> retrieveBooks() {
        return allEntries();
    }
    
    public List<Book> allEntries() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> rootEntry = cq.from(Book.class);
        CriteriaQuery<Book> all = cq.select(rootEntry);
        TypedQuery<Book> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }
    
    public Book retrieveBook(int id) {
        Book test = em.find(Book.class, id);
        em.close();
        return test;
    }
    
    public Book createBook(Book b) { 
        Book test = em.find(Book.class, b.getId());
        if (test == null) {
            tx.begin();
            em.persist(b);
            tx.commit();
            
            em.close();
        }

        return b;
    }
    
    public void deleteBook(int id) {
        Book test = em.find(Book.class, id);
        if (test !=null) {
            tx.begin();
            em.remove(test);
            tx.commit();
            
            em.close();
        }
    }
}
