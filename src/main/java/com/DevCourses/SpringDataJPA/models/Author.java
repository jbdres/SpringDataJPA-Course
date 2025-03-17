package com.DevCourses.SpringDataJPA.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Author {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;

    /* Note: Some Lombok annotations:
     * @Data annotation is equivalent to:
     * @Getter, @Setter, @RequiredArgsConstructor (final fields), @ToString, @EqualsAndHashCode
     * (These notes can be used separately.)
     *
     * @NoArgsConstructor: Constructor with no arguments.
     * @RequiredArgsConstructor: Constructor with final or @NonNull fields.
     * @AllArgsConstructor: Constructor with the all fields of the class.
     *
     * @Builder: Generates a Builder design pattern for the class, making it easy to create complex objects with many parameters.
     * @Log: Automatically generates a logger for the class.
     *
     * */

    public static void main(String[] args) {
        Author author = new Author();
        author.setFirstName("Julian");
        author.setAge(20);
        System.out.println(author.toString());
    }

}
