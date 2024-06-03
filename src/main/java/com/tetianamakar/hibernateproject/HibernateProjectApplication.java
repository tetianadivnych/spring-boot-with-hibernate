package com.tetianamakar.hibernateproject;

import com.tetianamakar.hibernateproject.entity.Employee;
import com.tetianamakar.hibernateproject.entity.Message;
import com.tetianamakar.hibernateproject.entity.Phone;
import com.tetianamakar.hibernateproject.repository.EmployeeRepository;
import com.tetianamakar.hibernateproject.repository.MessageRepository;
import com.tetianamakar.hibernateproject.repository.PhoneRepository;
import com.tetianamakar.hibernateproject.utils.Utils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateProjectApplication.class, args);
    }

    public void insertEmployees(EmployeeRepository repository) {
        repository.save(new Employee("tania", "makar"));
    }

    public void insertMessages(MessageRepository repository) {
        repository.save(new Message("hello"));
        repository.save(new Message("bye"));
    }

    public void insertPhones(EmployeeRepository repository, PhoneRepository phoneRepository) {
        Employee employee = repository.save(new Employee("tania", "makar"));
        phoneRepository.save(new Phone("38011111111", employee));
    }

    @Bean
    public CommandLineRunner runEmployees(EmployeeRepository repository) {
        return args -> {
            insertEmployees(repository);
            System.out.println("*****employees by last name: " + Utils.prepareEmployees(repository));
        };
    }

    @Bean
    public CommandLineRunner runMessages(MessageRepository repository) {
        return args -> {
            insertMessages(repository);
            System.out.println("*****all messages: " + repository.findAll());
            System.out.println("*****hello messages: " + repository.findByMessageContains("hello"));
        };
    }

    @Bean
    public CommandLineRunner runPhones(EmployeeRepository repository, PhoneRepository phoneRepository) {
        return args -> {
            insertPhones(repository, phoneRepository);
            System.out.println("*****380 phone numbers: " + Utils.preparePhones(phoneRepository));
        };
    }

}
