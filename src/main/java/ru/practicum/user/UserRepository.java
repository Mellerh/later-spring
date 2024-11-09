package ru.practicum.user;

import org.springframework.stereotype.Repository;
import ru.practicum.item.Item;

import java.util.List;

@Repository
public interface UserRepository {

    User getUserById(Long userId);

    List<User> findAll();

    User save(User user);

    List<Item> getAllUserItems(Long userId);

}
