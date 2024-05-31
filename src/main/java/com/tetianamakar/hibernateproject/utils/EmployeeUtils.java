package com.tetianamakar.hibernateproject.utils;

import com.tetianamakar.hibernateproject.Employee;
import com.tetianamakar.hibernateproject.EmployeeFormatter;
import com.tetianamakar.hibernateproject.EmployeeRepository;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeUtils {

    public static String prepareEmployees(EmployeeRepository repository) {
        List<Employee> employees = repository.findByLastName("makar");
        return employees.stream()
            .map(EmployeeFormatter::format)
            .collect(Collectors.joining(","));
    }


}
