package ru.practicum.user;

import lombok.Builder;
import lombok.Data;
import ru.practicum.item.Item;

import java.util.List;

@Data
@Builder
public class User {

    private Long id;
    private String email;
    private String name;
    private List<Item> listOfItems;

}
