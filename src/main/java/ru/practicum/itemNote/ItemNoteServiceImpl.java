package ru.practicum.itemNote;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.item.ItemRepository;
import ru.practicum.user.User;
import ru.practicum.user.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemNoteServiceImpl implements ItemNoteService {

    private final ItemNoteRepository itemNoteRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final ItemNoteMapper itemNoteMapper;

    @Override
    public List<ItemNoteDto> getItemNotesByUrl(Long userId, String url) {

        User user = userRepository.getUserById(userId);
        if (user == null) {
            throw new RuntimeException("user not found");
        }

        List<ItemNote> itemNoteList = itemNoteRepository.findAllByItemUrlContainingAndItemUserId(url, userId);

        return itemNoteList.stream()
                .filter(itemNote -> itemNote != null)
                .map(itemNote -> itemNoteMapper.toItemNoteDto(itemNote))
                .toList();
    }


    @Override
    public List<ItemNoteDto> getItemNotesByTag(Long userId, String tag) {

        User user = userRepository.getUserById(userId);
        if (user == null) {
            throw new RuntimeException("user not found");
        }

        List<ItemNote> itemNoteList = itemNoteRepository.getItemNotesByTag(tag, userId);

        return itemNoteList.stream()
                .filter(itemNote -> itemNote != null)
                .map(itemNote -> itemNoteMapper.toItemNoteDto(itemNote))
                .toList();
    }


}
