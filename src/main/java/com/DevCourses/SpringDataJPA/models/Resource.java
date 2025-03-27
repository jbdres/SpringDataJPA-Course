package com.DevCourses.SpringDataJPA.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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

    /* Notes: Inheritance strategy used in Spring Data JPA
     * Table Per Class Strategy
     * ---------------------
     * Pros
     * - No Null Values:
     *  - Each subclass has its own table, ensuring that only relevant
     *    columns are included. This eliminates the problem of sparse
     *    tables with null values.
     * - Subclass-specific Efficiency:
     *  - Queries for a specific subclass are faster because they only
     *    interact with one table, avoiding irrelevant data from other
     *    subclasses.
     * - Simplified Schema For Subclasses
     *  - Each subclass table contains only fields specific to that
     *    subclass, making the schema cleaner and easier to manage for
     *    subclass-specific operations.
     * - Write Operations:
     *  - Adding or updating subclass entities doesn't require touching
     *    unrelated tables, which can improve write efficiency.
     * ---------------------
     * Cons:
     * - Parent Class Queries:
     *  - Retrieving all entities of the parent class requires UNION
     *    operations across all subclass table, which can hurt performance.
     * - Complex Queries:
     *  - Queries spanning across multiple subclasses can become cumbersome
     *    and less efficient.
     * - Increased Table Count:
     *  - Having one table for each subclass increases the number of tables
     *    in the database, which can make the schema harder to manage in
     *    large applications.
     * - Disk Space Usage:
     *  - Separated tables might lead to higher disk usage compared to
     *    strategies like SINGLE_TABLE.
     * ---------------------
     * General Tip:
     * - The TABLE_PER_CLASS strategy is best when each subclass has unique
     *   fields and the queries are often specific to individual subclasses.
     *   It's not ideal when you frequently need to query the parent class
     *   or work with large hierarchies.
     * */

}
