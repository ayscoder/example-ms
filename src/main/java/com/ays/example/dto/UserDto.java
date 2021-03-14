package com.ays.example.dto;

import com.ays.example.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
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

    public static User to(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getUserName());
        user.setAddress(AddressDto.to(userDto.getAddress()));
//        user.setVehicles(VehicleDto.to(userDto.getVehicles()));
        return user;
    }

    public static UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUserName(user.getName());
        userDto.setAddress(AddressDto.from(user.getAddress()));
        userDto.setVehicles(VehicleDto.from(user.getVehicles()));
        return userDto;
    }
}
