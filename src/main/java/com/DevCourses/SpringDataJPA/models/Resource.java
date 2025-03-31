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

    /* ------------------------------------------------------------------
     * Notes: @Polymorphism annotation in Hibernate
     * This annotation was used to control how JPQL queries behaved when
     *   using inheritance with @Inheritance(strategy = InheritanceType.
     *   TABLE_PER_CLASS).
     *
     * What @Polymorphism did:
     * - Allowed defining whether queries on the base entity should include
     *   or exclude subclasses.
     * - @Polymorphism(type = Polymorphism.EXPLICIT): Ensured that queries
     *   only retrieved records from the base entity, excluding subclasses.
     * - @Polymorphism(type = Polymorphism.IMPLICIT): Included all subclasses
     *   in the query (default behavior).
     *
     * Why is @Polymorphism deprecated?
     * As of Hibernate 6, @Polymorphism has been removed because its behavior
     *   can now be controlled using JPQL(TYPE()) or alternative annotations.
     *   Hibernate recommends more flexible strategies for filtering query
     *   results.
     *
     * Alternatives to @Polymorphism
     * If you need the same control over base entity queries without
     *  including subclasses, you can use:
     * - @where (to manually filter base entities in queries)
     * - TYPE() in JPQL (to ensure only base entities are queried)
     * */

    /* ------------------------------------------------------------------
    * Example without @Polymorphism (Default behavior)
    * If you DO NOT use @Polymorphism, Hibernate will automatically retrieve
    *   all subclass data.
    *
    * List<Resource> results = entityManager.createQuery(
            "SELECT b FROM Resource b", Resource.class
      ).getResultList();
    *
    * Problem: This will execute a UNION ALL, including Video, File and
    *   Text data, even if you only wanted Resource.
    * */

    /* ------------------------------------------------------------------
    * Example using @where (Alternative to @Polymorphism)
    * Entity:
    * @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
    * @Where(clause = "dtype = 'Resource'")
    * public class Resource { ... }
    *
    * how does this work?
    * - The dtype column exist in the database.
    * - Only records where dtype = 'Resource' will be retrieved.
    * - Subclasses must have a different dtype value.
    *
    * Query:
    * List<Resource> results = entityManager.createQuery(
            "SELECT b FROM Resource b", Resource.class
      ).getResultList();
    *
    * Now it retrieves only Resource records, excluding subclasses.
    * */

    /* ------------------------------------------------------------------
    * Example using TYPE() in JPQL (Another alternative to @Polymorphism)
    * If you don't want to modify with @where, you can modify the query
    *   using TYPE().
    *
    * List<Resource> results = entityManager.createQuery(
            "SELECT b FROM Resource b WHERE TYPE(b) = Resource",
            Resource.class
      ).getResultList();
    *
    * The filters only Records instances, excluding Video, File and Text.
    * */

    /* ------------------------------------------------------------------
    * - Best alternative: @where, because it automatically filters result
    *       without modifying queries.
    * - Avoid @Polymorphism, as Hibernate 6 has removed support for it.
    * */

}
