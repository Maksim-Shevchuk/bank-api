package by.vsu.bank.service;

import by.vsu.bank.model.user.Role;

import java.util.List;

public interface RoleService {

    Role saveRole(Role role);

    Role updateRole(Role role);

    Role findById(long id);

    List<Role> findAll();

    void deleteById(long id);
}
