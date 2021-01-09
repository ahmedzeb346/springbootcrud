package com.coder.java.net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.coder.java.net.javaguides.springboot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}