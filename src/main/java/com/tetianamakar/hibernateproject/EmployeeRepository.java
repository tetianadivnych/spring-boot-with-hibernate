package com.tetianamakar.hibernateproject;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query("select m from Employee m where m.lastName like concat('%', ?1, '%')")
    List<Employee> findByLastName(String lastName);

}
