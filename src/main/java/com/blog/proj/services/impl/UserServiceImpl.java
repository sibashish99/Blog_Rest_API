package com.blog.proj.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.el.stream.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.proj.exceptions.ResourceNotFoundException;
import com.blog.proj.entities.User;
import com.blog.proj.payloads.UserDto;
import com.blog.proj.repo.UserRepo;
import com.blog.proj.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
        User user= this.dtoToUser(userDto);
        User saveUser=this.userRepo.save(user);
		return this.userToDTO(saveUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer user_id) {
		// TODO Auto-generated method stub
		 User existingUser = userRepo.findById(user_id)
	                .orElseThrow(() -> new ResourceNotFoundException("User", "id", user_id));
		 
      
            existingUser.setName(userDto.getName());
            existingUser.setPassword(userDto.getPassword());
            existingUser.setAbout(userDto.getAbout());

            // Save the updated user
            User updatedUser = userRepo.save(existingUser);

            // Convert   and return the updated user as DTO
            return userToDTO(updatedUser);
         
	}

	@Override
	public UserDto getUserById(Integer id) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        return userToDTO(user);
        
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		List<User> users = userRepo.findAll();

        // Convert the list of users to a list of DTOs
        return users.stream()
                .map(this::userToDTO)
                .collect(Collectors.toList());
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

		userRepo.delete(user);
	}

	private User dtoToUser(UserDto userDTO) {
		/**User user = new User();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setPassword(userDTO.getPassword());
		user.setAbout(userDTO.getAbout());
		user.setEmail(userDTO.getEmail());
		


		return user;*/
		
		User user= this.modelMapper.map(userDTO, User.class);
		return user;

	}

	private UserDto userToDTO(User user) {
		/**UserDto userDTO = new UserDto();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setPassword(user.getPassword());
		userDTO.setAbout(user.getAbout());
		userDTO.setEmail(user.getEmail());


		return userDTO;*/
		
		UserDto userDTO = this.modelMapper.map( user, UserDto.class);
		return userDTO;
	}
}
