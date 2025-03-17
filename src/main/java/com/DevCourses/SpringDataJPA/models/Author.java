package com.DevCourses.SpringDataJPA.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * JPA Entity representing an Author within the system.
 * Employs Lombok to automate the generation of boilerplate code (getters, setters, equals, hashCode, toString, constructors).
 * @Data generates getters, setters, equals, hashCode, toString, and constructors for all fields.
 * @NoArgsConstructor generates a no-argument constructor.
 * @Entity marks the class as a JPA entity, mapping it to a database table.
 */

@Data
@NoArgsConstructor
@Entity
public class Author {

    /*
     * Unique identifier for the Author.
     *
     * @Id designates this field as the entity's primary key.
     * @GeneratedValue specifies the primary key generation strategy.
     * - strategy = GenerationType.AUTO: Delegates strategy selection to the persistence provider (Hibernate in this case).
     * Hibernate, upon detecting PostgreSQL, defaults to a sequence strategy (SEQUENCE).
     * - generator = "custom_sequence": Associates this generation with the sequence generator defined by @SequenceGenerator.
     * @SequenceGenerator defines a custom sequence generator.
     * - name = "custom_sequence": Name of the sequence generator, referenced by @GeneratedValue.
     * - sequenceName = "author_sequence": Name of the sequence in the PostgreSQL database.
     * - allocationSize = 1: Defines the increment for the sequence per allocation. A value of 1 ensures unique, sequential IDs without gaps.
     * This is crucial for preventing "gaps" in the ID sequence.
     *
     * Technical considerations:
     * - GenerationType.AUTO allows portability across databases but may result in a less optimal strategy if not explicitly defined.
     * - Specifying allocationSize = 1 minimizes the risk of "gaps" in the ID sequence but can increase database load for high-throughput applications.
     * - Using sequenceName provides explicit control over the database sequence, aiding in administration and debugging.
     */

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "custom_sequence"
    )
    @SequenceGenerator(
            name = "custom_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;

}
