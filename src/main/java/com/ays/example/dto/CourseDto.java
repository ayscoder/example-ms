//package com.ays.example.dto;
//
//import com.ays.example.entity.Course;
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.experimental.FieldDefaults;
//
//import java.io.Serializable;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @author ayush agrahari created on 14/03/2021
// */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class CourseDto implements Serializable {
//    Long id;
//    String courseName;
//
//    public static List<Course> to(List<CourseDto> courseDtos) {
//        return courseDtos.stream().map(courseDto -> {
//            Course course = new Course();
//            course.setTitle(courseDto.getCourseName());
//            return course;
//        }).collect(Collectors.toList());
//    }
//
//    public static List<CourseDto> from(List<Course> courses) {
//        return courses.stream().map(c -> {
//            CourseDto courseDto = new CourseDto();
//            courseDto.setId(c.getId());
//            courseDto.setCourseName(c.getTitle());
//            return courseDto;
//        }).collect(Collectors.toList());
//    }
//}
