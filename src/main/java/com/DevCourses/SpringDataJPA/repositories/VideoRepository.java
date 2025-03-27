package com.DevCourses.SpringDataJPA.repositories;

import com.DevCourses.SpringDataJPA.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer> {
}
