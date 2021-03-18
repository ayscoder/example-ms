package com.ays.example.dto;

import com.ays.example.entity.Address;
//import com.ays.example.entity.Course;
import com.ays.example.entity.User;
import com.ays.example.entity.Vehicle;
//import com.ays.example.repository.CourseRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author ayush agrahari created on 14/03/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto implements Serializable {
    long id;
    String userName;
    AddressDto address;
    List<VehicleDto> vehicles;
//    List<CourseDto> courses;



    /**
     * Here we do all mappings for 1:1, 1:M and M:N
     *
     * @param userDto userDto
     * @return {@link User}
     */
    public static User to(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getUserName());

//        Address address = AddressDto.to(userDto.getAddress());
//        List<Vehicle> vehicles = VehicleDto.to(userDto.getVehicles());
//        List<Course> courses = CourseDto.to(userDto.getCourses());
//
//        //do mapping
//        //Child classes (Address and Vehicle) mapping
//        address.setUser(user);
//        vehicles.forEach(vehicle -> vehicle.setUser(user));
//        courses.forEach(course -> {
//            course.setUsers(Collections.singletonList(user));
//        });
//
//        //Parent class mapping with child classes
//        user.setAddress(address);
//        user.setVehicles(vehicles);
//        user.setCourses(courses);
        return user;
    }

    public static UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUserName(user.getName());
        userDto.setAddress(AddressDto.from(user.getAddress()));
        userDto.setVehicles(VehicleDto.from(user.getVehicles()));
//        userDto.setCourses(CourseDto.from(user.getCourses()));
        return userDto;
    }
}
