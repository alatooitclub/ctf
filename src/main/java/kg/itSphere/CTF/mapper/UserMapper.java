package kg.itSphere.CTF.mapper;

import kg.itSphere.CTF.dto.user.UserRequest;
import kg.itSphere.CTF.dto.user.UserResponse;
import kg.itSphere.CTF.entities.User;

import java.util.List;

public interface UserMapper {
    UserResponse toDto(User user);
    List<UserResponse> toDtoS(List<User> users);
    User toDtoUser(User user, UserRequest userRequest);
}
