package practicum.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class FakeUserRepository implements UserRepository {

    private final List<User> listOfUsers = new ArrayList<>(createSomeUsers(3));

    @Override
    public List<User> findAll() {
        return listOfUsers;
    }

    @Override
    public User save(User user) {
        throw new UnsupportedOperationException("Метод save ещё не готов.");
    }


    private static List<User> createSomeUsers(int q) {
        List<User> usersToCreate = new ArrayList<>();
        for (int i = 1; i <= q; i++) {
            User user = createUser((long) i);
            if (user != null) {
                usersToCreate.add(user);
            }
        }

        return Collections.unmodifiableList(usersToCreate);
    }

    private static User createUser(Long i) {
        return User.builder()
                .id(i)
                .name("name" + i)
                .email(i + "@email.ru")
                .build();
    }
}
