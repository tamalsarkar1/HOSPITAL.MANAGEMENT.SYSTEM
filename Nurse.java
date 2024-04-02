package com.hospitalmanagementsystem;

import javax.persistence.*;

@Entity
@Table(name = "nurse")
public class Nurse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private String gender;
    private String address;

    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    // Constructors

    public Nurse() {}

    public Nurse(String name, int age, String gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    // toString() method

    @Override
    public String toString() {
        return "Nurse [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", address=" + address + "]";
    }
}