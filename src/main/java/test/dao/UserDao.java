package test.dao;

import java.util.List;
import test.model.User;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
