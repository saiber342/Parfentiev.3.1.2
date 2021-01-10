package CRUDApplication.service;

import CRUDApplication.dao.RoleDAO;
import CRUDApplication.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public List<Role> getRoles() {
        return roleDAO.getRoles();
    }

    @Override
    public Role showById(Long id) {
        return roleDAO.showById(id);
    }

    @Override
    public void saveRole(Role role) {
        roleDAO.saveRole(role);
    }

    @Override
    public void editRole(Long id, Role editedRole) {
        Role roleToBeUpdated = roleDAO.showById(id);
        roleToBeUpdated.setRoleName(editedRole.getRoleName());
        roleDAO.editRole(editedRole);

    }

    @Override
    public void delete(Long id) {
        roleDAO.delete(roleDAO.showById(id));

    }

    @Override
    public Role getRoleName(String name) {
        return roleDAO.getRoleName(name);
    }
}
