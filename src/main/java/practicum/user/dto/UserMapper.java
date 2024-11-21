package practicum.user.dto;

import org.springframework.stereotype.Component;
import practicum.user.User;

import java.time.format.DateTimeFormatter;

@Component
public class UserMapper {

    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy.MM.dd, HH:mm:ss");

    public User toUserModel(UserCreateDto userDto) {
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .build();
    }

    public UserReturnDto toUserDto(User user) {
        return UserReturnDto.builder()
                .fullName(user.getFirstName() + " " + user.getLastName())
                .email(user.getEmail())
                .registrationDate(
                        user.getRegistrationDate() != null
                                ? DATE_FORMATTER.format(user.getRegistrationDate())
                                : null
                )
                .build();
    }

}
