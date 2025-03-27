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
@Inheritance(strategy = InheritanceType.JOINED)
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
     * Joined Strategy
     * ---------------------
     * Pros
     * - Normalized Structure:
     *  - Each entity in the hierarchy has its own table, reducing
     *    redundancy and ensuring data integrity.
     *  - No null values, as fields are stored only where they are
     *    relevant.
     * - Scalability:
     *  - Ideal for handling complex inheritance hierarchy with large
     *    numbers of entities and fields.
     *  - Easier to add new subclasses without disrupting the schema.
     * - Data Integrity:
     *  - Relational design helps avoid inconsistencies, making it
     *    suitable for applications with strict requirements for
     *    structure data.
     * - Flexible Queries:
     *  - You can query specific subclasses or the parent entity without
     *    unnecessary data clutter.
     * ---------------------
     * Cons:
     * - Performance Overhead:
     *  - Queries for parent entities require JOIN operations across
     *    multiple tables, which can slow down retrieval in large datasets.
     * - Complexity:
     *  - More tables mean more effort in managing relationships and
     *    schema migrations.
     * - Configuration:
     *  - Slightly mor challenging to configure compared to SINGLE_TABLE.
     * - Disk Space:
     *  - While normalized, storing relationships between tables can lead
     *    to increased disk usage.
     * ---------------------
     * General Tip:
     * - The Joined Strategy shines when you need a well-structured and
     *   scalable solution for applications with complex inheritance
     *   hierarchies. It's perfect for scenarios where avoiding null and
     *   maintaining data integrity are critical, even at the cost of
     *   slightly slower query performance.
     * */

}
