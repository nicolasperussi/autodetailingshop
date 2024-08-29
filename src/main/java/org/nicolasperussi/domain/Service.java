package org.nicolasperussi.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;

    @ManyToMany(mappedBy = "services")
    private List<Appointment> appointments;
}
