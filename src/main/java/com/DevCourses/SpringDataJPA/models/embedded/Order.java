package com.DevCourses.SpringDataJPA.models.embedded;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "the_order")
public class Order {

    @EmbeddedId
    private OrderId id; // The primary key of the Order entity

    /*
    * This is not a primary key
    * - Now the attributes in Address are include in Order
    * - It is a way to reusing code.
    * */
    @Embedded
    private Address address;

    private String orderInfo;
    private String anotherField;

}
