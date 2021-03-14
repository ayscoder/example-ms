package com.ays.example.service;

import com.ays.example.dto.AddressDto;
import com.ays.example.dto.UserDto;
import com.ays.example.dto.VehicleDto;
import com.ays.example.entity.Address;
import com.ays.example.entity.User;
import com.ays.example.entity.Vehicle;
import com.ays.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 1:1 relationship between user:address
 * 1:M relationship between user:vehicles
 * M:N relationship between users:vehicles
 * @author ayush agrahari created on 14/03/2021
 */
@Service
public class RelationshipService {

    private final UserRepository userRepository;

    public RelationshipService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto save(UserDto userDto) {
        List<Vehicle> vehicles = VehicleDto.to(userDto.getVehicles());
        Address address = AddressDto.to(userDto.getAddress());
        User user = UserDto.to(userDto);

        //do mapping
        //Child classes (Address and Vehicle) mapping
        address.setUser(user);
        vehicles.forEach(vehicle -> vehicle.setUser(user));

        //Parent class mapping with child classes
        user.setAddress(address);
        user.setVehicles(vehicles);

        //Finally save user parent class
        User savedUser = userRepository.save(user);
        return UserDto.from(savedUser);
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
