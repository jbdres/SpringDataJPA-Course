package com.DevCourses.SpringDataJPA.models.embedded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode // These methods are required in an embedded key class

// The main annotation to used embedded Ids
@Embeddable

/*
 * This class doesn't need the @Entity annotation because it will
 *   not be persisted.
 * */
public class OrderId {

    /* Note:
     * - All attributes of this class will be the primary key
     *       of the Order entity.
     * What are the embedded keys in JPA?
     * - Embedded keys (also called composed keys) are a way to define a
     *   primary key consisting of multiple columns in JPA. Instead of using
     *   a single field, you use multiple fields grouped into a separated
     *   class.
     * Why use embedded keys?
     * - When a single column isn't enough to uniquely identify a record.
     * - Common in many-to-many relationships or junction tables (e.g.,
     *   OrderItem linking Order and Product).
     * - Helps maintain database normalization and avoid redundant data.
     * Implements Serializable
     * - When using embedded IDs in Spring Boot with JPA, you must implement
     *    Serializable in the embedded key class. This is because JPA
     *    requires that composite primary key classes be serializable.
     * - Why?
     *  - It ensures the key can be used as a cache key (e.g., in
     *    Hibernate's second-level cache).
     *  - JPA uses serialization mechanisms internally when handling
     *    composite keys.
     *  - It guarantees correct behavior when storing the entity in a
     *    distributed environment (e.g., microservices)
     * */

    private String username;
    private LocalDateTime orderDate;

}
