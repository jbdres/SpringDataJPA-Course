package com.DevCourses.SpringDataJPA.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Resource {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer size;
    private String url;

}
