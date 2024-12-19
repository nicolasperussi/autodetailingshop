package org.nicolasperussi.service;

import org.nicolasperussi.dao.VehicleDAO;
import org.nicolasperussi.domain.Customer;
import org.nicolasperussi.domain.Vehicle;

public class VehicleService {
    private VehicleDAO vehicleDAO;

    public VehicleService() {
        this.vehicleDAO = getVehicleDAO();
    }

    private VehicleDAO getVehicleDAO() {
        if (vehicleDAO == null) {
            vehicleDAO = new VehicleDAO();
        }

        return vehicleDAO;
    }

    public void createVehicle(Vehicle vehicle) {
        vehicleDAO.save(vehicle);
    }

    public Vehicle findById(final int id) {
        return vehicleDAO.findById(id);
    }
}
