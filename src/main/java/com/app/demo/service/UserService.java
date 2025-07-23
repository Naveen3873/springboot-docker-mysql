package com.app.demo.service;

import java.util.List;
import java.util.Map;
import com.app.demo.dto.UserDTO;

public interface UserService {

	List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO createUser(UserDTO dto);
    UserDTO updateUser(Long id, UserDTO dto);
    void deleteUser(Long id);
    Map<String, List<UserDTO>> getGroupByRole();

}
