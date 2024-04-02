package com.hospitalmanagementsystem;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String specialization;
    private String degree;
    private int consultantCharges;
    private String address;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;

    @OneToOne(mappedBy = "doctor")
    private Nurse nurse;

    // Constructors

    public Doctor() {}

    public Doctor(String name, String specialization, String degree, int consultantCharges, String address) {
        this.name = name;
        this.specialization = specialization;
        this.degree = degree;
        this.consultantCharges = consultantCharges;
        this.address = address;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getConsultantCharges() {
        return consultantCharges;
    }

    public void setConsultantCharges(int consultantCharges) {
        this.consultantCharges = consultantCharges;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    // toString() method

    @Override
    public String toString() {
        return "Doctor [id=" + id + ", name=" + name + ", specialization=" + specialization + ", degree=" + degree +
                ", consultantCharges=" + consultantCharges + ", address=" + address + "]";
    }
}