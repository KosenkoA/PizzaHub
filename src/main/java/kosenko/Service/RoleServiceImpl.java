package kosenko.Service;

import kosenko.Entity.Role;
import kosenko.Repository.RoleRepository;
import kosenko.Service.interfaces.RoleService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleRepository roleRepository;

    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Optional<Role> delete(long id) {
        Optional<Role> deletedRole = roleRepository.findById(id);
        roleRepository.delete(deletedRole);
        return deletedRole;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role update(Role role) {
        return roleRepository.saveAndFlush(role);
    }

    @Override
    public Optional<Role> findById(long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
