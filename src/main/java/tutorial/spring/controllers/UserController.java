package tutorial.spring.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tutorial.spring.dto.UserResponseDto;
import tutorial.spring.model.User;
import tutorial.spring.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/inject")
    public void injectUsers() {
        User user1 = new User("user1@gmail.com", "password");
        User user2 = new User("user2@gmail.com", "password");
        User user3 = new User("user3@gmail.com", "password");
        User user4 = new User("user4@gmail.com", "password");

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.listUsers().stream()
                .map(this::getUserRespDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        Optional<User> user = userService.listUsers().stream()
                .filter(userFromList -> userFromList.getId().equals(userId))
                .findFirst();
        return getUserRespDto(user.orElseThrow());
    }

    private UserResponseDto getUserRespDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
