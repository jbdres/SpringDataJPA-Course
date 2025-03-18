package com.DevCourses.SpringDataJPA.repositories;

import com.DevCourses.SpringDataJPA.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
