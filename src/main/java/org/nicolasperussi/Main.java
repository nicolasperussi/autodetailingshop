package org.nicolasperussi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.nicolasperussi.domain.Customer;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("autoDetailingPU");
        EntityManager em = emf.createEntityManager();

        // Begin a transaction
        em.getTransaction().begin();

        // Example: Create a new customer
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        em.persist(customer);

        em.getTransaction().commit();
        em.close();

        emf.close();
    }
}
