package tutorial.spring.service;

import java.util.List;
import tutorial.spring.model.User;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
