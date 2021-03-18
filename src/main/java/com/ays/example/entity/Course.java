//package com.ays.example.entity;
//
//import lombok.AccessLevel;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.experimental.FieldDefaults;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * M:N - user:course
// * 1:M - 1 User can choose many courses
// * 1:M - 1 Course can be chosen by many users
// * @author ayush agrahari created on 14/03/2021
// */
//@Entity
//@Table(name = "course")
//@Getter
//@Setter
//@FieldDefaults(level= AccessLevel.PRIVATE)
//@NoArgsConstructor
//public class Course implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long id;
//
//    String title;
//
//    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
//    List<User> users = new ArrayList<>();
//
//}
