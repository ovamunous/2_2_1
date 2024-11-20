package hiber.dao;


import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private SessionFactory sessionFactory;

    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User t join fetch t.car");
        return query.getResultList();
    }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public User getUserByCar(String model, int series) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("from User t join fetch t.car where t.car.model = :model and t.car.series = :series")
                .setParameter("model", model).setParameter("series", series).getSingleResult();
    }

}
