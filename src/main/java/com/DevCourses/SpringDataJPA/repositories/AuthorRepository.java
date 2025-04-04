package com.DevCourses.SpringDataJPA.repositories;

import com.DevCourses.SpringDataJPA.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    /* Query Generation From The Method Name:
     * - The query generation from the method name is a query generation
     *   strategy where the invoked query is derived from the name of the
     *   query method.
     * */

    List<Author> findByLastName(String lastName);

    List<Author> findByFirstNameAndLastName(String firstName, String lastName);

    List<Author> findAllByFirstNameIgnoreCase(String firstName);

    List<Author> findAllByFirstNameContainingIgnoreCase(String firstName);

    List<Author> findAllByFirstNameStartsWithIgnoreCase(String firstName);

    Optional<Author> findByEmail(String email);

    int countAllByAge(int age);

    void deleteByAge(int age);

}
