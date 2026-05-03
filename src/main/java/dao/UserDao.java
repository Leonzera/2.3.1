package dao;

import model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    List<User> listUsers();

    User findUserById(Long id);

    void updateUser(User user);

    void deleteUserById(Long id);
}
