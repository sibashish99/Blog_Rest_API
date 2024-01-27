package com.blog.proj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.proj.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
