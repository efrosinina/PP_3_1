package net.proselyte.PP_3_1.dao;

import net.proselyte.PP_3_1.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Здесь мы используем метод persist() EntityManager.
     * Пропущенный объект User станет постоянным объектом.
     * "Значит его изменение свойств отслеживается менеджером сущностей для синхронизации с базой данных.
     */

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    /**
     * Метод merge() синхронизирует изменения с базой данных и возвращает постоянный объект.
     * Пропущенный объект становится неуправляемым.
     */
    @Override
    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager
                .createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }
}