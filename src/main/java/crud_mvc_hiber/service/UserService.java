package crud_mvc_hiber.service;

import crud_mvc_hiber.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void save(User user);

    User getUserById(int id);

    void update(int id, User user);

    void delete(int id);
}
