package org.nicolasperussi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.nicolasperussi.domain.Task;

import java.util.List;

public class TaskDAO {
    private static TaskDAO instance;
    protected EntityManager em;

    public static TaskDAO getInstance() {
        if (instance == null) {
            instance = new TaskDAO();
        }
        return instance;
    }

    public TaskDAO() {
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
    public List<Task> findAll() {
        return em.createQuery("FROM " + Task.class.getName()).getResultList();
    }

    public Task findById(final int id) {
        return em.find(Task.class, id);
    }

    public void save(Task task) {
        try {
            em.getTransaction().begin();
            em.persist(task);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void merge(Task task) {
        try {
            em.getTransaction().begin();
            em.merge(task);
            em.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void remove(Task task) {
        try {
            em.getTransaction().begin();
            task = em.find(Task.class, task.getId());
            em.remove(task);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void removeById(final int id) {
        try {
            Task task = findById(id);
            remove(task);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
