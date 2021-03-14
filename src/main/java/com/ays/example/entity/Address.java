package com.ays.example.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ayush agrahari created on 14/03/2021
 */
@Entity
@Table(name = "address")
@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;

    /**
     * Lets have join column in address table.
     * Here name of join column is user_id
     *
     * JoinColumn:
     * The @JoinColumn annotation is used to specify the foreign key column in the owner of the relationship.
     *
     */
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    User user;
}