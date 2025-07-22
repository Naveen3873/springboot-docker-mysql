package com.app.demo.service.impl;

import com.app.demo.dto.UserDTO;
import com.app.demo.entity.User;
import com.app.demo.repository.UserRepository;
import com.app.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
        		.map(user -> UserDTO.builder()
        				.id(user.getId())
        				.name(user.getName())
        				.age(user.getAge())
                        .salary(user.getSalary())
                        .role(user.getRole())
        				.build())
        		.collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
    	Optional<User> user = userRepository.findById(id);
    	return user.map(u -> UserDTO.builder()
    			.id(u.getId())
    			.name(u.getName())
    			.age(u.getAge())
    			.salary(u.getSalary())
    			.role(u.getRole())
    			.build())
    			.orElse(null);
    }
    
    @Override
    public UserDTO createUser(UserDTO dto) {
        User saved = userRepository.save(User.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .salary(dto.getSalary())
                .role(dto.getRole())
                .build());

        return UserDTO.builder()
                .id(saved.getId())
                .name(saved.getName())
                .age(saved.getAge())
                .salary(saved.getSalary())
                .role(saved.getRole())
                .build();
    }
    
    @Override
    public UserDTO updateUser(Long id, UserDTO dto) {
    	Optional<User> optionalUser = userRepository.findById(id);
    	if(optionalUser.isPresent()) {
    		User user = optionalUser.get();
    		user.setName(dto.getName());
    		User updated = userRepository.save(user);
    		return UserDTO.builder()
    				.id(updated.getId())
    				.name(updated.getName())
    				.age(updated.getAge())
                    .salary(updated.getSalary())
                    .role(updated.getRole())
    				.build();
    	}
    	return null;
    }
    
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
