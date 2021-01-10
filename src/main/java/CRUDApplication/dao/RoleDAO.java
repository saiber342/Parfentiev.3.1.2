package CRUDApplication.dao;

import CRUDApplication.models.Role;

import java.util.List;

public interface RoleDAO {

    List<Role> getRoles();
    Role showById(Long id);
    void saveRole(Role role);
    void editRole(Role role);
    void delete(Role role);
    Role getRoleName(String name);
}
