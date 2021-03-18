package com.ays.example.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User entity class where each user will have own address
 * Same address cannot be used by other user.
 * <p>
 * And Each user can have many vehicles
 */
@Entity
@Table(name = "user")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    /**
     * here we mapped by which mean we are doing mapping with address class and
     * in address class we have instance variable name is User user;
     * that is why we use instance variable name for mappedBy value which is "user"
     * <p>
     * fetch:
     * Defines a strategy for fetching data from the database.
     * By default, it is EAGER which means that the data must be eagerly fetched.
     * We have set it to LAZY to fetch the entities lazily from the database.
     * <p>
     * mappedBy:
     * Defines the entity that owns the relationship which is the Address entity in our case.
     * <p>
     * Cascade:
     * Defines a set of cascadable operations that are applied to the associated entity.
     * CascadeType.ALL means to apply all cascading operations to the related entity.
     * Cascading operations are applied when you delete or update the parent entity
     * <p>
     * Optional:
     * Defines whether the relationship is optional. If set to false then a non-null relationship must always exist.
     */
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Address address;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Vehicle> vehicles = new ArrayList<>();

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @JoinTable(name = "user_course",
//            joinColumns = {
//                    @JoinColumn(name = "user_id", referencedColumnName = "id",
//                            nullable = false, updatable = false) },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "course_id", referencedColumnName = "id",
//                            nullable = false, updatable = false) })
//    private List<Course> courses = new ArrayList<>();

//    public void addCourse(Course course) {
//        this.courses.add(course);
//        course.getUsers().add(this);
//    }

//    public void removeCourse(Course course) {
//        this.getCourses().remove(course);
//        course.getUsers().remove(this);
//    }
//
//    public void removeCourses() {
//        for (Course course : new ArrayList<>(courses)) {
//            removeCourse(course);
//        }
//    }
}