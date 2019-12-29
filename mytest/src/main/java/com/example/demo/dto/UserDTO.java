package com.example.demo.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "users")
public class UserDTO {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String email;
    private String address;
}
