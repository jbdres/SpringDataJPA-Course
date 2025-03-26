package com.DevCourses.SpringDataJPA.models;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
// If we want to use a builder. it's necessary to use @SuperBuilder instead @Builder because this last one it's not appropriate to use within a child class (why?)
@MappedSuperclass // With this annotation, this entity isn't created in the database
public class BaseEntity { // The parent entity

    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;

}
