package by.vsu.bank.service.impl;

import by.vsu.bank.exception.ResourceNotFoundException;
import by.vsu.bank.model.user.Role;
import by.vsu.bank.repository.RoleRepository;
import by.vsu.bank.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role role) {
        return null;
    }

    @Override
    public Role findById(long id) {
        return roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Role.class.getSimpleName(), id));
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        if (!roleRepository.existsById(id)) {
            throw new ResourceNotFoundException(RoleServiceImpl.class.getSimpleName(), id);
        }
        roleRepository.deleteById(id);
    }

}
