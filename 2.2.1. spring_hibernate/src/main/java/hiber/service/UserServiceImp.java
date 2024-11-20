package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserDao userDao;
    private CarService carService;

    public UserServiceImp(UserDao userDao, CarService carService) {
        this.userDao = userDao;
        this.carService = carService;
    }

    @Transactional
    @Override
    public void add(User user) {
        carService.addCar(user.getCar());
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    @Transactional
    public User getUserByCar(String model, int series) {
        return userDao.getUserByCar(model, series);
    }

}
