package com.DevCourses.SpringDataJPA;

import com.DevCourses.SpringDataJPA.models.Author;
import com.DevCourses.SpringDataJPA.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    // Execute code at application startup
    @Bean
    public CommandLineRunner commandLineRunner(AuthorRepository authorRepository) {
        return args -> {
            // Use the @Builder annotation from lombok to create an author
            Author author = Author.builder()
                    .firstName("Julian")
                    .lastName("Tovar")
                    .email("julian@mail.com")
                    .age(20)
                    .build();
            // Insert the object in the database
            authorRepository.save(author);
        };
    }

}
