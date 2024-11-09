package ru.practicum.user;

import org.springframework.stereotype.Service;
import ru.practicum.item.Item;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();

    User saveNewUser(User user);

    List<Item> getAllUserItems(Long userId);

}
