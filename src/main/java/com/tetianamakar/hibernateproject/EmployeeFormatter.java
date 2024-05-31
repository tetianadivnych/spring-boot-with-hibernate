package com.tetianamakar.hibernateproject;

public class EmployeeFormatter {

    public static String format(Employee employee) {
        return "Employee{id=" + employee.getId() +
               ", firstName='" + employee.getFirstName() + '\'' +
               ", lastName='" + employee.getLastName() + '\'' +
               '}';
    }
}
