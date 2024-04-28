package kg.itSphere.CTF.services;

import kg.itSphere.CTF.dto.role.RoleRequest;
import kg.itSphere.CTF.dto.role.RoleResponse;

import java.util.List;

public interface RoleService {
    List<RoleResponse> all();
    void updateById(Long id, RoleRequest request);
    void create(RoleRequest request);
}
