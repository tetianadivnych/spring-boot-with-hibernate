package com.tetianamakar.hibernateproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne()
    @JoinColumn(name = "employee_id")
    private Employee employeeId;

    public Phone() {
    }

    public Phone(String phoneNumber, Employee employeeId) {
        this.phoneNumber = phoneNumber;
        this.employeeId = employeeId;
    }

    public Phone(Employee employeeId) {
        this.employeeId = employeeId;
    }
}
