package kg.itSphere.CTF.mapper.impl;

import kg.itSphere.CTF.dto.user.UserRequest;
import kg.itSphere.CTF.dto.user.UserResponse;
import kg.itSphere.CTF.entities.User;
import kg.itSphere.CTF.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserResponse toDto(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setPassword(user.getPassword());
        return userResponse;
    }

    @Override
    public List<UserResponse> toDtoS(List<User> users) {
        List<UserResponse> userResponses = new ArrayList<>();
        for(User user : users) {
            userResponses.add(toDto(user));
        }
        return userResponses;
    }

    @Override
    public User toDtoUser(User user, UserRequest userRequest) {
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        return user;
    }
}
