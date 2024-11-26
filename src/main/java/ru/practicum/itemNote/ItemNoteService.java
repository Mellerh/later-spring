package ru.practicum.itemNote;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface ItemNoteService {

    List<ItemNoteDto> getItemNotesByUrl(Long userId, String url);

    List<ItemNoteDto> getItemNotesByTag(Long userId, String tag);

    List<ItemNoteDto> listAllItemsWithNotes(Long userId, Integer from, Integer size);

    ItemNoteDto addNewItemNote(Long userId, ItemNoteDto itemNoteDto);

}
