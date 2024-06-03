package com.tetianamakar.hibernateproject.repository;

import com.tetianamakar.hibernateproject.entity.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query("select m from Employee m where m.lastName like %:lastName%")
    List<Employee> findByLastName(String lastName);

}
