package com.DevCourses.SpringDataJPA.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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
     * Hibernate, upon detecting MySQL, defaults to a table strategy (TABLE).
     * - generator = "author_id_gen": Associates this generation with the table generator defined by @TableGenerator.
     * @TableGenerator defines a primary key generator based on a database table.
     * - name = "author_id_gen": Name of the table generator, referenced by @GeneratedValue.
     * - table = "id_generator": Name of the table that stores the sequence values.
     * - pkColumnName = "id_name": Name of the column that stores the sequence names.
     * - valueColumnName = "id_value": Name of the column that stores the current sequence values.
     * - allocationSize = 1: Defines the increment for the sequence per allocation. A value of 1 ensures unique, sequential IDs without gaps.
     * This is crucial for preventing "gaps" in the ID sequence.
     *
     * Technical considerations:
     * - TableGenerator is useful for databases that do not support native sequences.
     * - Specifying allocationSize = 1 minimizes the risk of "gaps" in the ID sequence but can increase database load due to frequent table updates.
     * - The "id_generator" table must exist in the database with the specified columns before the application can generate IDs.
     */

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "author_id_gen"
    )
    @TableGenerator(
            name = "author_id_gen",
            table = "id_generator",
            pkColumnName = "id_name",
            valueColumnName = "id_value",
            allocationSize = 1
    )
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;

}
