package kg.itSphere.CTF.services.impl;

import kg.itSphere.CTF.dto.auth.AuthRequest;
import kg.itSphere.CTF.dto.auth.AuthResponse;
import kg.itSphere.CTF.entities.Role;
import kg.itSphere.CTF.entities.User;
import kg.itSphere.CTF.exception.CustomException;
import kg.itSphere.CTF.mapper.AuthMapper;
import kg.itSphere.CTF.repository.RoleRepository;
import kg.itSphere.CTF.repository.UserRepository;
import kg.itSphere.CTF.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final AuthMapper authMapper;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(AuthRequest authRequest) {
        if(roleRepository.findByName("USER").isEmpty()) {
            Role role = new Role();
            role.setName("USER");
            roleRepository.save(role);
        }
        if(userRepository.findByEmail(authRequest.getEmail()).isPresent()) {
            throw new CustomException("User is found", HttpStatus.FOUND);
        } else {
            User user = authMapper.toDtoUser(authRequest);
            user.setRole(roleRepository.findByName("USER").get());
            userRepository.save(user);
            return authMapper.toDto(user);
        }
    }

    @Override
    public AuthResponse login(AuthRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail(),
                        authRequest.getPassword()
                )
        );
        User user = userRepository.findByEmail(authRequest.getEmail()).orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND));
        return authMapper.toDto(user);
    }
}
