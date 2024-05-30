package com.tetianamakar.hibernateproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateProjectApplication.class, args);
    }

    public void insertMessages(MessageRepository repository) {
        repository.save(new Message("hello"));
        repository.save(new Message("bye"));
    }

    @Bean
    public CommandLineRunner run(MessageRepository repository) {
        return args -> {
            insertMessages(repository);
            System.out.println("all messages: " + repository.findAll());
            System.out.println("hello messages: " + repository.findByMessageContains("hello"));
        };
    }

}
