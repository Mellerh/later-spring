package ru.practicum.item;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {

    private Long id;
    private Long userId;
    private String url;

}
