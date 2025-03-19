package com.DevCourses.SpringDataJPA.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Course {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String description;

    // Who's the owner of the relationship?
    /*
     * - Responsible for the maintaining the foreign key values in the join
     *   table and the other entity is considered the inverse of the
     *   relationship and does not have any foreign keys in the join table.
     * */

    // Owner of the relationship
    @ManyToMany
    @JoinTable(
            name = "authors_courses",
            joinColumns = {
                    @JoinColumn(name = "course_id"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id")
            }
    )
    private List<Author> authors;

    /* Explanation:
     * - @ManyToMany: This annotation signifies that a Course can have multiple Authors, and an Author can be associated with multiple Courses.
     * - @JoinTable: This annotation specifies the join table that will manage the many-to-many relationship.
     * - name = "authors_courses": This sets the name of the join table in the database to authors_courses.
     * - joinColumns = { @JoinColumn(name = "course_id") }: This defines the column(s) in the join table that reference the primary key of the Course entity.
     *     -> @JoinColumn(name = "course_id") indicates that the course_id column in the authors_courses table will hold the foreign key referencing the Course table's primary key.
     * - inverseJoinColumns = { @JoinColumn(name = "author_id") }: This defines the column(s) in the join table that reference the primary key of the Author entity.
     * - @JoinColumn(name = "author_id") indicates that the author_id column in the authors_courses table will hold the foreign key referencing the Author table's primary key.
     * - private List<Author> authors;: This declares a list of Author objects within the Course entity. This list represents the authors associated with the course.
     * */

}
