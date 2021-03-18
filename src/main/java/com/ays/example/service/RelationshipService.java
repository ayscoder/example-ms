package com.ays.example.service;

import com.ays.example.dto.AddressDto;
//import com.ays.example.dto.CourseDto;
import com.ays.example.dto.UserDto;
import com.ays.example.dto.VehicleDto;
import com.ays.example.entity.Address;
//import com.ays.example.entity.Course;
import com.ays.example.entity.User;
import com.ays.example.entity.Vehicle;
//import com.ays.example.repository.CourseRepository;
import com.ays.example.repository.UserRepository;
import com.ays.example.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 1:1 relationship between user:address
 * 1:M relationship between user:vehicles
 * M:N relationship between users:vehicles
 *
 * @author ayush agrahari created on 14/03/2021
 */
@Service
public class RelationshipService {

    private final UserRepository userRepository;
    //    @Autowired
    //    private CourseRepository courseRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    public RelationshipService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto save(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getUserName());

        Address address = AddressDto.to(userDto.getAddress());
        List<Vehicle> vehicles = VehicleDto.to(userDto.getVehicles());

        address.setUser(user);
        for (Vehicle v : vehicles) {
            v.setUser(user);
        }

        user.setAddress(address);
        user.setVehicles(vehicles);

        //        List<CourseDto> courseDtos = userDto.getCourses();
        //        for (CourseDto courseDto : courseDtos) {
        //            Course course = courseRepository.findByTitle(courseDto.getCourseName());
        //            if (course == null) {
        //                course = new Course();
        //            }
        //            course.setTitle(courseDto.getCourseName());
        //            user.getCourses().add(course);
        //            course.getUsers().add(user);
        //        }

        User savedUser = userRepository.save(user);
        return UserDto.from(savedUser);
    }

    public UserDto update(long userId, UserDto userDto) {
        Optional<User> byId = userRepository.findById(userId);
        if (byId.isPresent()) {
            User user = byId.get();
            if (userDto.getUserName() != null) {
                user.setName(userDto.getUserName());
            }
            if (userDto.getAddress() != null) {
                user.setAddress(AddressDto.to(userDto.getAddress()));
            }
            if (userDto.getVehicles() != null) {
                List<VehicleDto> vehicleDtos = userDto.getVehicles();
                for (VehicleDto vehicleDto : vehicleDtos) {
                    Optional<Vehicle> existingVehicle = vehicleRepository.findById(vehicleDto.getId());
                    if (existingVehicle.isPresent()) {
                        Vehicle vehicle = existingVehicle.get();
                        vehicle.setVehicleName(vehicleDto.getVehicleName());
                    }
                }
            }
            userRepository.save(user);
            return UserDto.from(user);
        }
        return userDto;
    }

    public List<UserDto> read() {
        Iterable<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> {
            userDtos.add(UserDto.from(user));
        });
        return userDtos;
    }

    public void update() {
    }

    public void delete() {
    }
}
