package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.IUserRepository;
import com.sun.deploy.security.SelectableSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOList = userRepository.findAll();
        if (userDTOList.size() > 0) {
            return userDTOList;
        } else {
            return new ArrayList<UserDTO>();
        }

    }
}