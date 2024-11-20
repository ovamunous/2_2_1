package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImp implements CarDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUserByCar(String model, int series) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("from User t join fetch t.car where t.car.model = :model and t.car.series = :series")
                .setParameter("model", model).setParameter("series", series).getSingleResult();
    }
}
