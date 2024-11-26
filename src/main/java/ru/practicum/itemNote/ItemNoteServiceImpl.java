package ru.practicum.itemNote;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.practicum.item.Item;
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

    @Override
    public List<ItemNoteDto> listAllItemsWithNotes(Long userId, Integer from, Integer size) {
        User user = userRepository.getUserById(userId);
        if (user == null) {
            throw new RuntimeException("user not found");
        }

        // объект пагинации
        PageRequest pageRequest = PageRequest.of(from > 0 ? from / size : 0, size);

        List<ItemNote> itemNoteList = itemNoteRepository.findAllByUserId(userId, pageRequest);
        return itemNoteList.stream()
                .filter(itemNote -> itemNote != null)
                .map(itemNote -> itemNoteMapper.toItemNoteDto(itemNote))
                .toList();
    }

    @Override
    public ItemNoteDto addNewItemNote(Long userId, ItemNoteDto itemNoteDto) {
        User user = userRepository.getUserById(userId);
        if (user == null) {
            throw new RuntimeException("user not found");
        }

        // надо понять, почему он требует тип Optional
        Item item = itemRepository.findByItemId(itemNoteDto.getItemId());
        if (item == null) {
            throw new RuntimeException("item not found");
        }

        ItemNote itemNote = itemNoteMapper.toItemNoteModel(itemNoteDto, item);

        // сохраняем ItemNote в БД
        ItemNote savedItemNot = itemNoteRepository.save(itemNote);

        return itemNoteMapper.toItemNoteDto(savedItemNot);
    }


}
