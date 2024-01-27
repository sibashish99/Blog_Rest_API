package com.blog.proj.services;

import java.util.List;

import com.blog.proj.entities.User;
import com.blog.proj.payloads.UserDto;

public interface UserService {
	UserDto createUser(UserDto userdto) ;
	UserDto updateUser(UserDto userDto,Integer id);
	UserDto getUserById(Integer id);
	List<UserDto> getAllUser();
	void deleteUser(Integer id);
}
