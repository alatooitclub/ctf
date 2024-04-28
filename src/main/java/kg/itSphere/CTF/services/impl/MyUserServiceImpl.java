package kg.itSphere.CTF.services.impl;

import kg.itSphere.CTF.dto.user.UserRequest;
import kg.itSphere.CTF.dto.user.UserResponse;
import kg.itSphere.CTF.entities.User;
import kg.itSphere.CTF.exception.CustomException;
import kg.itSphere.CTF.mapper.UserMapper;
import kg.itSphere.CTF.repository.UserRepository;
import kg.itSphere.CTF.services.MyUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MyUserServiceImpl implements MyUserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponse> all() {
        return userMapper.toDtoS(userRepository.findAll());
    }

    @Override
    public UserResponse findByEmail(String email) {
        return userMapper.toDto(userRepository.findByEmail(email).orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND)));
    }

    @Override
    public void updateById(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND));
        userRepository.save(userMapper.toDtoUser(user, userRequest));
    }

    @Override
    public void deleteById(Long id) {
        if(userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new CustomException("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
