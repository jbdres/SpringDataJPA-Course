package com.DevCourses.SpringDataJPA.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true) // With inheritance, this annotation must be used
@SuperBuilder // It's necessary use this annotation in the whole entities that extends from a parent entity
@Entity
public class Author extends BaseEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private int age;

    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;

}
