package hiber.service;

import hiber.model.User;

public interface CarService {
    public User getUserByCar(String model, int series);
}
