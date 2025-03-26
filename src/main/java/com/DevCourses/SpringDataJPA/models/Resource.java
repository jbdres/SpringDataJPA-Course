package com.DevCourses.SpringDataJPA.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Resource {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer size;
    private String url;

    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    /* Pros y cons about inheritance in Spring Data JPA
     * With inheritance you can create queries that span multiples entities
     *   without have separated queries for each query.
     *
     * ways of strategies in inheritance?
     *   - Join table per class (the base class?)
     *   - Joint table per concrete class
     *
     * Tips: (Find out the difference between Composition and inheritance)
     * Composition over inheritance -> It's recommended
     *   Composition is more flexible and easier to change
     *
     * But for this project, inheritance will be used.
     * */
}
