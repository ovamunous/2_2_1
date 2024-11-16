package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car car = new Car("ChinessCar", 22222);
        User user = new User("123", "Lastname4", "user4@mail.ru", car);
        user.setFirstName("John");
        userService.add(user);
        List<User> users = userService.listUsers();
        for (User user1 : users) {
            System.out.println(user1);
        }
        System.out.println(userService.findCar("ChinessCar", 22222));
        userService.delete(user);
        context.close();
    }
}
