package com.tetianamakar.hibernateproject;

import com.tetianamakar.hibernateproject.utils.EmployeeUtils;
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

    @Bean
    public CommandLineRunner runMessages(EmployeeRepository repository) {
        return args -> {
            insertEmployees(repository);
            System.out.println("employees: " + EmployeeUtils.prepareEmployees(repository));
        };
    }

    @Bean
    public CommandLineRunner runEmployees(MessageRepository repository) {
        return args -> {
            insertMessages(repository);
            System.out.println("all messages: " + repository.findAll());
            System.out.println("hello messages: " + repository.findByMessageContains("hello"));
        };
    }

}
