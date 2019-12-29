package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface IUserService {
    public List<UserDTO> getAllUsers();
}
