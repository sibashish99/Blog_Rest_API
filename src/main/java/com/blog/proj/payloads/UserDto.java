package com.blog.proj.payloads;



import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	  private int id;
	  
	  @NotEmpty
	  @Size(min=4, message="User name must be least four character")
	  private String name;
	  @NotEmpty
	  @Size(min=3,max=10, message="Password must be least three characters and max ten. ")
	  private String password;
	  @NotEmpty
	  private String about;
	  @Email(message="Your email address is not valid")
	  private String email;
}
