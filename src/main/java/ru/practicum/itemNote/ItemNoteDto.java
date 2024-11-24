package ru.practicum.itemNote;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ItemNoteDto {

    private Long id;
    private Long itemId;
    private String text;
    private String dateOfNote;
    private String itemUrl;

}
