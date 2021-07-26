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
    public User show(int id) {
        TypedQuery<User> query = (TypedQuery<User>) entityManager.createQuery("from User where id = :id");
        User user = (User) query.setParameter("id", id).getSingleResult();
        return user;
    }

    @Override
    public void update(int id, User updateUser) {
        User toUpdate = show(id);
        toUpdate.setName(updateUser.getName());
        toUpdate.setLatName(updateUser.getLatName());
        toUpdate.setEmail(updateUser.getEmail());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void delete(int id) {
        TypedQuery<User> query = (TypedQuery<User>) entityManager.createQuery("delete User where id = :id");
        query.setParameter("id", id).executeUpdate();
    }
}