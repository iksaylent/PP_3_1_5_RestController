package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.model.Role;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private RoleDao roleDao;
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public void createRole(Role role) {
        roleDao.createRole(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public Role finedRoleByRoleName(String roleName) {
        return roleDao.finedRoleByRoleName(roleName);
    }

    @Override
    public Role finedRoleById(long id) {
        return roleDao.finedRoleById(id);
    }


}