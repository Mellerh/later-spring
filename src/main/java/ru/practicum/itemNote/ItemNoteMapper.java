package ru.practicum.itemNote;


import org.springframework.stereotype.Component;
import ru.practicum.item.Item;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Component
public class ItemNoteMapper {

    public ItemNote toItemNoteModel(ItemNoteDto itemNoteDto, Item item) {

        return ItemNote.builder()
                .item(item)
                .text(itemNoteDto.getText())
                .build();
    }


    public ItemNoteDto toItemNoteDto(ItemNote itemNote) {
        String dateOfNote = DateTimeFormatter
                .ofPattern("yyyy.MM.dd hh:mm:ss")
                .withZone(ZoneOffset.UTC)
                .format(itemNote.getDateOfNote());

        return ItemNoteDto.builder()
                .id(itemNote.getId())
                .itemId(itemNote.getItem().getId())
                .text(itemNote.getText())
                .dateOfNote(dateOfNote)
                .itemUrl(itemNote.getItem().getUrl())
                .build();

    }

}
