package com.ays.example.dto;

import com.ays.example.entity.Vehicle;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ayush agrahari created on 14/03/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VehicleDto implements Serializable {
    Long id;
    String vehicleName;

    public static List<Vehicle> to(List<VehicleDto> vehicleDtos) {
        return vehicleDtos.stream().map(vehicleDto -> {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleName(vehicleDto.getVehicleName());
            return vehicle;
        }).collect(Collectors.toList());
    }

    public static List<VehicleDto> from(List<Vehicle> vehicles) {
        return vehicles.stream().map(v -> {
            VehicleDto vehicleDto = new VehicleDto();
            vehicleDto.setId(v.getId());
            vehicleDto.setVehicleName(v.getVehicleName());
            return vehicleDto;
        }).collect(Collectors.toList());
    }
}
