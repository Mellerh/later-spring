package ru.practicum.item;

import java.util.List;

public interface ItemService {

    List<Item> findByUserId(long userId);

    Item addNewItem(Long userId, Item item);

    void deleteItem(Long userId, Long itemId);

}
