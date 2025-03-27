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
//@PrimaryKeyJoinColumn(name = "video_id") // Custom name to the id column
// This annotation it's optional | default name: id
public class Video extends Resource {

    /* Note:
     * - This entity has its own table on the database.
     * - An id column is automatically created into the associated table.
     * - This id column stores the primary key (Video) and the foreign key
     *   (to Resource) at the same time.
     * */

    private int length;

}
