package kg.itSphere.CTF.mapper;

import kg.itSphere.CTF.dto.role.RoleRequest;
import kg.itSphere.CTF.dto.role.RoleResponse;
import kg.itSphere.CTF.entities.Role;

import java.util.List;

public interface RoleMapper {
    RoleResponse toDto(Role role);
    List<RoleResponse> toDtoS(List<Role> roles);
    Role toDtoRole(RoleRequest request);
}
