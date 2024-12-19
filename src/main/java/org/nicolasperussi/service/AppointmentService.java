package org.nicolasperussi.service;

import org.nicolasperussi.dao.AppointmentDAO;
import org.nicolasperussi.domain.Appointment;

public class AppointmentService {
    private AppointmentDAO appointmentDAO;

    public AppointmentService() {
        this.appointmentDAO = getAppointmentDAO();
    }

    private AppointmentDAO getAppointmentDAO() {
        if (appointmentDAO == null) {
            appointmentDAO = new AppointmentDAO();
        }

        return appointmentDAO;
    }

    public void createService(Appointment appointment) {
        appointmentDAO.save(appointment);
    }

    public Appointment findById(final int id) {
        return appointmentDAO.findById(id);
    }
}
