package com.DevCourses.SpringDataJPA.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Author {

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

    // Inverse of the relationship
    /* - @ManyToMany(mappedBy = "value")
     *   -> value is the name of the attribute in the entity that owns the relationship
     *      that refers this class.
     * */
    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;

    /* Explanation:
     * - @ManyToMany(mappedBy = "authors"): This annotation again signifies a many-to-many relationship.
     *     -> mappedBy = "authors": This is crucial for bidirectional relationships. It tells JPA that the courses list in the Author entity is
     *        mapped by the authors list in the Course entity. Essentially, it indicates that the Course entity is the owning side of the
     *        relationship. This is important because only the owning side is responsible for updating the join table.
     * - private List<Course> courses;: This declares a list of Course objects within the Author entity. This list represents the courses authored by the author.
     * */

}
