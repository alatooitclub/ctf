package kg.itSphere.CTF.services;

import kg.itSphere.CTF.dto.auth.AuthRegisterRequest;
import kg.itSphere.CTF.dto.auth.AuthRequest;
import kg.itSphere.CTF.dto.auth.AuthResponse;

public interface AuthService {
    AuthResponse register(AuthRegisterRequest authRegisterRequest);
    AuthResponse login(AuthRequest authRequest);
}
