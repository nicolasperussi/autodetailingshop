package org.nicolasperussi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.nicolasperussi.domain.Customer;

import java.util.List;

public class CustomerDAO {
    private static CustomerDAO instance;
    protected EntityManager em;

    public static CustomerDAO getInstance() {
        if (instance == null) {
            instance = new CustomerDAO();
        }

        return instance;
    }

    public CustomerDAO() {
        em = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("autoDetailingPU");

        if (em == null) {
            em = factory.createEntityManager();
        }

        return em;
    }

    @SuppressWarnings("unchecked")
    public List<Customer> findAll() {
        return em.createQuery("FROM " + Customer.class.getName()).getResultList();
    }

    public Customer findById(final int id) {
        return em.find(Customer.class, id);
    }

    public void save(Customer customer) {
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }
    public void merge(Customer customer) {
        try {
            em.getTransaction().begin();
            em.merge(customer);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void remove(Customer customer) {
        try {
            em.getTransaction().begin();
            customer = em.find(Customer.class, customer.getId());
            em.remove(customer);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void removeById(final int id) {
        try {
            Customer customer = findById(id);
            remove(customer);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
