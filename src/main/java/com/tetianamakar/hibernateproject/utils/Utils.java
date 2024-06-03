package com.tetianamakar.hibernateproject.utils;

import com.tetianamakar.hibernateproject.entity.Employee;
import com.tetianamakar.hibernateproject.entity.Phone;
import com.tetianamakar.hibernateproject.repository.EmployeeRepository;
import com.tetianamakar.hibernateproject.repository.PhoneRepository;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static String prepareEmployees(EmployeeRepository repository) {
        List<Employee> employees = repository.findByLastName("makar");
        return employees.stream()
            .map(Utils::formatEmployee)
            .collect(Collectors.joining(","));
    }

    public static String preparePhones(PhoneRepository repository) {
        List<Phone> phones = repository.findByPhoneNumberContaining("390");
        return phones.stream()
            .map(Utils::formatPhones)
            .collect(Collectors.joining(","));
    }

    public static String formatEmployee(Employee employee) {
        return "Employee{id=" + employee.getId() +
            ", firstName='" + employee.getFirstName() + '\'' +
            ", lastName='" + employee.getLastName() + '\'' +
            '}';
    }

    public static String formatPhones(Phone phone) {
        return "Phone{id=" + phone.getId() + '\'' +
            ", phoneNumber='" + phone.getPhoneNumber() + '\'' +
            '}';
    }


}
