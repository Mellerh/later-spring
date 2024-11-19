package practicum.user;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User saveNewUser(User user);

}
