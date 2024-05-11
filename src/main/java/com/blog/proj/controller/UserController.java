package com.blog.proj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.proj.payloads.UserDto;
import com.blog.proj.services.UserService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@PostMapping("/createUser")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId")  Integer uId){
		UserDto updatedUser= this.userService.updateUser(userDto, uId);
		return ResponseEntity.ok(updatedUser);
		
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId")  Integer uId){
		this.userService.deleteUser(uId);
		return ResponseEntity.ok().build();
	}
	
	//get user
	@GetMapping("/getUserById/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Integer uId) {
        UserDto userDto = this.userService.getUserById(uId);

        if (userDto != null) {
            return ResponseEntity.ok(userDto);
        } else {
            // Handle the case where the user with the given ID is not found
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtos = this.userService.getAllUser();
        return ResponseEntity.ok(userDtos);
    }
	
	
}
