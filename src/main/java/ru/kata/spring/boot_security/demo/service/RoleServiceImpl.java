package ru.kata.spring.boot_security.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.models.Role;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Transactional
    @Override
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Transactional
    @Override
    public List<Role> getAllRole() {
        return roleDao.getAllRole();
    }

    @Transactional
    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }
}