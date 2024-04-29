package kg.itSphere.CTF.mapper;

import kg.itSphere.CTF.dto.auth.AuthRegisterRequest;
import kg.itSphere.CTF.dto.auth.AuthRequest;
import kg.itSphere.CTF.dto.auth.AuthResponse;
import kg.itSphere.CTF.entities.User;

public interface AuthMapper {
    AuthResponse toDto(User user);
    User toDtoUser(AuthRegisterRequest authRegisterRequest);
}
