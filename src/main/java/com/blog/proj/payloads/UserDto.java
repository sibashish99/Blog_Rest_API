package com.blog.proj.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	  private int id;
	  private String name;
	  private String password;
	  private String about;
	  private String email;
}
