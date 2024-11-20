package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);
        Car car1 = new Car("BMW", 11111);
        Car car2 = new Car("ChinessCar", 22222);
        Car car3 = new Car("Lada", 33333);
        User user1 = new User("John", "Lastname1", "user1@mail.ru", car1);
        User user2 = new User("Bill", "Lastname2", "user2@mail.ru", car2);
        User user3 = new User("Valera", "Lastname3", "user3@mail.ru", car3);
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println(carService.getUserByCar("Lada", 33333));
        userService.delete(user1);
        context.close();
    }
}
