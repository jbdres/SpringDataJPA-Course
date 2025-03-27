package com.DevCourses.SpringDataJPA;

import com.DevCourses.SpringDataJPA.models.Video;
import com.DevCourses.SpringDataJPA.repositories.VideoRepository;
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
    public CommandLineRunner commandLineRunner(VideoRepository videoRepository) {
        return args -> {
            // Use the @Builder annotation from lombok to create an author
            Video video = Video.builder()
                    .name("The first video")
                    .length(5)
                    .build();
            // Insert the object in the database
            videoRepository.save(video);
        };
    }

}
