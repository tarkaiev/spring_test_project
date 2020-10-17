package test.service;

import java.util.List;
import test.model.User;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
