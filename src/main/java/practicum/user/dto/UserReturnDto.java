package practicum.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserReturnDto {

    private String fullName;
    private String email;
    private String registrationDate;

}
