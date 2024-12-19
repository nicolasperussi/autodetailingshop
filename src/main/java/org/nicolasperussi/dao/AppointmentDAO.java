package org.nicolasperussi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.nicolasperussi.domain.Appointment;

import java.util.List;

public class AppointmentDAO {
    private static AppointmentDAO instance;
    protected EntityManager em;

    public static AppointmentDAO getInstance() {
        if (instance == null) {
            instance = new AppointmentDAO();
        }
        return instance;
    }

    public AppointmentDAO() {
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
    public List<Appointment> findAll() {
        return em.createQuery("FROM " + Appointment.class.getName()).getResultList();
    }

    public Appointment findById(final int id) {
        return em.find(Appointment.class, id);
    }

    public void save(Appointment appointment) {
        try {
            em.getTransaction().begin();
            em.persist(appointment);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void merge(Appointment appointment) {
        try {
            em.getTransaction().begin();
            em.merge(appointment);
            em.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void remove(Appointment appointment) {
        try {
            em.getTransaction().begin();
            appointment = em.find(Appointment.class, appointment.getId());
            em.remove(appointment);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void removeById(final int id) {
        try {
            Appointment appointment = findById(id);
            remove(appointment);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
