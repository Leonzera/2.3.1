package dao;

import model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> listUsers() {
        return em.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User findUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void saveOrUpdateUser(User user) {
        if (user.getId() == null || user.getId() <= 0) {
            em.persist(user);
        } else {
            em.merge(user);
        }
    }

    @Override
    public void deleteUserById(Long id) {
        em.createQuery("DELETE FROM User WHERE id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}




