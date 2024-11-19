package practicum.user;

import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table
public class User {

    private Long id;
    private String email;
    private String name;

}
