package kg.itSphere.CTF.mapper.impl;

import kg.itSphere.CTF.config.JwtService;
import kg.itSphere.CTF.dto.auth.AuthRegisterRequest;
import kg.itSphere.CTF.dto.auth.AuthRequest;
import kg.itSphere.CTF.dto.auth.AuthResponse;
import kg.itSphere.CTF.entities.User;
import kg.itSphere.CTF.mapper.AuthMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthMapperImpl implements AuthMapper {
    private final JwtService jwtService;
    private final PasswordEncoder encoder;
    @Override
    public AuthResponse toDto(User user) {
        String token = jwtService.generateToken(user);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(token);
        return authResponse;
    }

    @Override
    public User toDtoUser(AuthRegisterRequest authRegisterRequest) {
        User user = new User();
        user.setFirstName(authRegisterRequest.getFirstName());
        user.setLastName(authRegisterRequest.getLastName());
        user.setEmail(authRegisterRequest.getEmail());
        user.setPassword(encoder.encode(authRegisterRequest.getPassword()));
        return user;
    }
}
