package kg.itSphere.CTF.services.impl;

import kg.itSphere.CTF.dto.role.RoleRequest;
import kg.itSphere.CTF.dto.role.RoleResponse;
import kg.itSphere.CTF.exception.CustomException;
import kg.itSphere.CTF.mapper.RoleMapper;
import kg.itSphere.CTF.repository.RoleRepository;
import kg.itSphere.CTF.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    @Override
    public List<RoleResponse> all() {
        return roleMapper.toDtoS(roleRepository.findAll());
    }

    @Override
    public void updateById(Long id, RoleRequest request) {
        roleRepository.findById(id).orElseThrow(() -> new CustomException("Role not found!", HttpStatus.NOT_FOUND));
        roleRepository.save(roleMapper.toDtoRole(request));
    }

    @Override
    public void create(RoleRequest request) {
        if(roleRepository.findByName(request.getName()).isPresent()) {
            throw new CustomException("Role with this name is already exist!", HttpStatus.FOUND);
        } else {
            roleRepository.save(roleMapper.toDtoRole(request));
        }
    }
}
