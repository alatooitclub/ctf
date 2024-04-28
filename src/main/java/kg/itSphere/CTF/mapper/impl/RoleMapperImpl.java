package kg.itSphere.CTF.mapper.impl;

import kg.itSphere.CTF.dto.role.RoleRequest;
import kg.itSphere.CTF.dto.role.RoleResponse;
import kg.itSphere.CTF.entities.Role;
import kg.itSphere.CTF.mapper.RoleMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleMapperImpl implements RoleMapper {
    @Override
    public RoleResponse toDto(Role role) {
        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setId(role.getId());
        roleResponse.setName(role.getName());
        return roleResponse;
    }

    @Override
    public List<RoleResponse> toDtoS(List<Role> roles) {
        List<RoleResponse> roleResponses = new ArrayList<>();
        for(Role role : roles) {
            roleResponses.add(toDto(role));
        }
        return roleResponses;
    }

    @Override
    public Role toDtoRole(RoleRequest request) {
        Role role = new Role();
        role.setName(request.getName());
        return role;
    }
}
