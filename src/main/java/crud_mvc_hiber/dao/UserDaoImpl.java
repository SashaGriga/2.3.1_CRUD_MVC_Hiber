package crud_mvc_hiber.dao;


import org.springframework.stereotype.Component;
import crud_mvc_hiber.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = entityManager.createQuery(" from User", User.class).getResultList();
        return allUsers;
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User update(User updateUser) {
        entityManager.merge(updateUser);
        return updateUser;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}