package CRUDApplication.dao;

import CRUDApplication.models.Role;
import CRUDApplication.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getRoles() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public Role showById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public void saveRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void editRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void delete(Role role) {
        entityManager.remove(role);
    }

    @Override
    public Role getRoleName(String role) {
       return entityManager.find(Role.class, role);
    }

}
