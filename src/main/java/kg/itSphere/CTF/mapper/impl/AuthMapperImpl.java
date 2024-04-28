package kg.itSphere.CTF.mapper.impl;

import kg.itSphere.CTF.config.JwtService;
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
    public User toDtoUser(AuthRequest authRequest) {
        User user = new User();
        user.setEmail(authRequest.getEmail());
        user.setPassword(encoder.encode(authRequest.getPassword()));
        return user;
    }
}
