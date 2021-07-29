package crud_mvc_hiber.dao;

import crud_mvc_hiber.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void save(User user);

    User getUserById(int id);

    User update(User user);

    void delete(int id);
}
