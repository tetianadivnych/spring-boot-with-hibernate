package com.tetianamakar.hibernateproject.repository;

import com.tetianamakar.hibernateproject.entity.Phone;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepository extends CrudRepository<Phone, Integer> {

    @Query("select p from Phone p where p.phoneNumber like %:code%")
    List<Phone> findByPhoneNumberContaining(String code);

}
