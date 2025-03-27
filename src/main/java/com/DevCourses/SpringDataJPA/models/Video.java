package com.DevCourses.SpringDataJPA.models;

import jakarta.persistence.Entity;
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
public class Video extends Resource {

    /* Note:
     * - The entity's table will have all the columns from the
     *   Resource's table.
     * */

    private int length;

}
