package crud_mvc_hiber.dao;

import crud_mvc_hiber.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void save(User user);

    User show(int id);

    void update(int id, User user);

    void delete(int id);
}
