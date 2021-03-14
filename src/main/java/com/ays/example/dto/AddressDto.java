package com.ays.example.dto;

import com.ays.example.entity.Address;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * @author ayush agrahari created on 14/03/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressDto implements Serializable {
    Long id;
    String city;

    public static Address to(AddressDto addressDto) {
        Address address = new Address();
        address.setCity(addressDto.getCity());
        return address;
    }

    public static AddressDto from(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setCity(address.getCity());
        return addressDto;
    }
}
