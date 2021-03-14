package com.ays.example.controller;

import com.ays.example.dto.UserDto;
import com.ays.example.service.RelationshipService;
import com.ays.example.util.WebResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ays.example.common.enums.ApiMessage.*;
import static com.ays.example.util.WebUtil.toResponseEntity;

/**
 * @author ayush agrahari created on 14/03/2021
 */
@RestController
@RequestMapping(value = "/v1")
public class RelationshipController {

    private final RelationshipService relationshipService;

    public RelationshipController(RelationshipService relationshipService) {
        this.relationshipService = relationshipService;
    }

    /**
     * Create user with address details along with Vehicles
     *
     * @param userDto user details in json format
     *                e.g {"userName":"Ayush","address":{"city":"Bangalore"},"vehicles":[{"vehicleName":"alto","vehicleName":"swift"}]}
     *
     * @return ResponseEntity if {@link WebResponse} type
     */
    @PostMapping(value = "/users")
    public ResponseEntity<WebResponse<UserDto>> create(@RequestBody UserDto userDto) {
        UserDto saveDto = relationshipService.save(userDto);
        return toResponseEntity(new WebResponse.Builder<UserDto>(HttpStatus.OK, "r1", USER_CREATE, 1).withData(saveDto).build());
    }

    @GetMapping(value = "/users")
    public ResponseEntity<WebResponse<List<UserDto>>> read() {
        List<UserDto> allUsers = relationshipService.read();
        return toResponseEntity(
                new WebResponse.Builder<List<UserDto>>(HttpStatus.OK, "r1", USER_READ, allUsers.size()).withData(allUsers).build());
    }

    public ResponseEntity<?> update() {
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }

    public ResponseEntity<?> delete() {
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
