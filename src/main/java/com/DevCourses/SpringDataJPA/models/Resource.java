package com.DevCourses.SpringDataJPA.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
public class Resource extends BaseEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer size;
    private String url;

    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    /* Notes: Inheritance strategy used in Spring Data JPA
     * Single Table Strategy
     * - Is a way to map an inheritance hierarchy of entities on a single
     *   database table.
     * - Discriminator Column: A special column, called the discriminator
     *   column, is used to distinguish between different entities types.
     * ---------------------
     * Pros
     * - Simplicity:
     *  - All entities are stored in a single table, making the database
     *    schema straightforward.
     *  - No need for joins, which can simplify queries.
     * - Performance:
     *  - Queries are typically faster since all data is in one table,
     *    avoiding the overhead of joins.
     *  - Suitable for inheritance hierarchies with minimal distinct fields.
     * - Easy to Implement:
     *  - Less configuration compared to other inheritance strategies (like
     *    JOINED or TABLE_PER_CLASS)
     * - Good for small hierarchies
     *  - Works best when subclasses don't have too many unique fields.
     * ---------------------
     * Cons:
     * - Sparse Table: Can lead to a lot of null values if subclasses have
     *   many unique fields that others don't share.
     * - Potential for Errors: The presence of null values can make data
     *   validation and interpretation tricky.
     * - Scalability Issues: Not ideal for large hierarchies or when the
     *   number of entities grows significantly, as the table can become
     *   unwieldy.
     * - Data Anomalies: Changes to the hierarchy (e.g., adding a new
     *   subclass with unique fields) might require schema alterations,
     *   which could disrupt the table.
     * - Disk Space: Although it avoid joins, the sparse structure might
     *   waste disk space due to unused columns.
     * */

}
