package ru.practicum.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.practicum.user.UserRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FakeItemRepository implements ItemRepository {

    private Long generatedId = 0L;
    private final UserRepository userRepository;

    @Override
    public List<Item> findByUserId(Long userId) {
        return userRepository.getAllUserItems(userId);
    }

    @Override
    public Item save(Item item) {
        item.setId(++generatedId);

        List<Item> userItems = userRepository.getAllUserItems(item.getUserId());
        userItems.add(item);

        return item;
    }

    @Override
    public void deleteByUserIdAndItemId(Long userId, Long itemId) {
        List<Item> userItems = userRepository.getAllUserItems(userId);

        userItems.removeIf(item -> item.getId().equals(itemId));
    }


}
