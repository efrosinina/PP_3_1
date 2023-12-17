package net.proselyte.PP_3_1.dao;

import net.proselyte.PP_3_1.model.User;
import java.util.List;

public interface UserDao {

    void saveUser(User user);

    User updateUser(User user);

    void deleteUser(Long id);

    List<User> getAllUsers();

    User getUserById(Long id);
}