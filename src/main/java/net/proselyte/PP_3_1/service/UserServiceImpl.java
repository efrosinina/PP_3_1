package net.proselyte.PP_3_1.service;

import net.proselyte.PP_3_1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.proselyte.PP_3_1.dao.UserDao;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() { return userDao.getAllUsers(); }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
}
