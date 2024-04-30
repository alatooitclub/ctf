package kg.itSphere.CTF.services;

import kg.itSphere.CTF.dto.user.UserRequest;
import kg.itSphere.CTF.dto.user.UserResponse;
import kg.itSphere.CTF.entities.Image;

import java.util.List;

public interface MyUserService {
    List<UserResponse> all();
    UserResponse findByEmail(String email);
    void updateById(Long id, UserRequest userRequest, Image image);
    void deleteById(Long id);
}
