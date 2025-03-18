package com.DevCourses.SpringDataJPA.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Author {

    /* Notes:
     * Repositories:
     * - In Spring Data JPA a repository is a Java interface
     *   that is used to abstract the data access layer from
     *   the business logic.
     * - Repositories are typically defined as interfaces that
     *   extends one of the Spring Data JPA repository interfaces,
     *   such as: JPA repository, extends from three other different
     *   repositories. We can extend it to have our own repository.
     *
              ------------- Repository -------------
              |                                    |
  PagingAndSortingRepository                CrudRepository
              |                                    |
ListPagingAndSortingRepository            ListCrudRepository
              |                                    |
              ------------ JpaRepository -----------
                                 |
                          AuthorRepository
     *
     * */

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private int age;
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @Column(insertable = false)
    private LocalDateTime lastModified;

}
