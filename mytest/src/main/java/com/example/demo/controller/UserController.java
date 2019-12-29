package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.IUserService;
import com.example.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService iUserService;
//    @Autowired
//    IUserRepository iUserRepository;
private List<UserDTO> userDTOList = new CopyOnWriteArrayList<>();

    @GetMapping("/getinit")
//    public List<UserDTO> getUsersInit() {
//        List<UserDTO> listUsers = iUserService.getAllUsers();
//        BeanUtils.copyProperties(listUsers,userDTOList);
//        return listUsers;
//    }
    public ResponseEntity<List<UserDTO>> getUserInit(){
        List<UserDTO> listUsers = iUserService.getAllUsers();
        BeanUtils.copyProperties(listUsers,userDTOList);
        ResponseEntity<List<UserDTO>> responseEntity = new ResponseEntity<List<UserDTO>>(listUsers,new HttpHeaders(), HttpStatus.OK);
        return responseEntity;
    }



    @PostConstruct
    public void init(){
        // Thêm null vào List để bỏ qua vị trí số 0;
        userDTOList.add(null);

    }
    @GetMapping("/getlist")
    public List<UserDTO> getUserEntityList(){
        return userDTOList;
    }


}
