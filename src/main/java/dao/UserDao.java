package dao;

import model.User;
import java.util.List;

public interface UserDao {

    List<User> listUsers();

    User findUserById(Long id);

    void saveOrUpdateUser(User user);

    void deleteUserById(Long id);
}
