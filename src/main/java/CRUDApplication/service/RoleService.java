package CRUDApplication.service;

import CRUDApplication.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();
    Role showById(Long id);
    void saveRole(Role role);
    void editRole(Long id, Role role);
    void delete(Long id);
    Role getRoleName(String name);
}
