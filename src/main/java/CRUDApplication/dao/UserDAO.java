package CRUDApplication.dao;

import CRUDApplication.models.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    User getUserById(Long id);
    void saveUser(User user);
    void editUser(User user);
    void delete(User user);
    User getUserByName(String name);
}
