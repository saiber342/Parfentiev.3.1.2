package CRUDApplication.dao;

import CRUDApplication.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public void editUser(User user) {
        entityManager.merge(user);

    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public User getUserByName(String username) {
        User user = null;
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.username=:username");
        query.setParameter("username", username);
        try {
            user = (User) query.getSingleResult();
        } catch (Exception e) {

        }
        return user;
    }

}
