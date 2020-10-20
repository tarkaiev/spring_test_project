package tutorial.spring.dao;

import java.util.List;
import tutorial.spring.model.User;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    User get(Long userId);
}
