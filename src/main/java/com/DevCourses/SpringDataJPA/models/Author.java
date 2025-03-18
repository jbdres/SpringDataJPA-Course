package com.DevCourses.SpringDataJPA.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Author {

    /* Note:
    * - With the @Column annotation we can set the next properties of a field:
    *   name, unique, nullable, insertable, updatable, columnDefinition,
    *   table, length, precision and scale.
    *   ------------------------------
    *   e.g., @Column(
                insertable = false,
                updatable = true
        )
        private String anyColumn
    *   ------------------------------
    * */

    @Id
    @GeneratedValue // strategy = GenerationType.AUTO
    private Integer id;
    @Column(name = "column_first_name")
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    private int age;
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;
    @Column(insertable = false)
    private LocalDateTime lastModified;

}
