package ru.practicum.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.item.Item;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<Item> getAllUserItems(Long userId) {
        if (userRepository.getUserById(userId) == null) {
            throw new RuntimeException("Пользователь с id " + userId + " не найден.");
        }

        return userRepository.getAllUserItems(userId);
    }
}
