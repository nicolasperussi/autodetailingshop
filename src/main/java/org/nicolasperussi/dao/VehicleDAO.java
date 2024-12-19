package org.nicolasperussi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.nicolasperussi.domain.Customer;
import org.nicolasperussi.domain.Vehicle;

import java.util.List;

public class VehicleDAO {
    private static VehicleDAO instance;
    protected EntityManager em;

    public static VehicleDAO getInstance() {
        if (instance == null) {
            instance = new VehicleDAO();
        }
        return instance;
    }

    public VehicleDAO() {
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
    public List<Vehicle> findAll() {
        return em.createQuery("FROM " + Vehicle.class.getName()).getResultList();
    }

    public Vehicle findById(final int id) {
        return em.find(Vehicle.class, id);
    }

    public void save(Vehicle vehicle) {
        try {
            em.getTransaction().begin();
            em.persist(vehicle);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void merge(Vehicle vehicle) {
        try {
            em.getTransaction().begin();
            em.merge(vehicle);
            em.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void remove(Vehicle vehicle) {
        try {
            em.getTransaction().begin();
            vehicle = em.find(Vehicle.class, vehicle.getId());
            em.remove(vehicle);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void removeById(final int id) {
        try {
            Vehicle vehicle = findById(id);
            remove(vehicle);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
