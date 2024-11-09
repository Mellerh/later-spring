package ru.practicum.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.practicum.item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class FakeUserRepository implements UserRepository {

    private final Map<Long, User> mapOfUsers = new HashMap<>(createSomeUsers(3));

    @Override
    public User getUserById(Long userId) {
        return mapOfUsers.get(userId);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(mapOfUsers.values());
    }

    @Override
    public User save(User user) {
        throw new UnsupportedOperationException("Метод save ещё не готов.");
    }

    @Override
    public List<Item> getAllUserItems(Long userId) {
        return mapOfUsers.get(userId).getListOfItems();
    }


    private static Map<Long, User> createSomeUsers(int q) {
        Map<Long, User> usersToCreate = new HashMap<>();
        for (int i = 1; i <= q; i++) {
            User user = createUser((long) i);
            if (user != null) {
                usersToCreate.put((long) i, user);
            }
        }

        return usersToCreate;
    }

    private static User createUser(Long i) {
        return User.builder()
                .id(i)
                .name("name" + i)
                .email(i + "@email.ru")
                .build();
    }
}
