package ru.practicum.itemNote;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class ItemNoteController {

    private final ItemNoteService itemNoteService;

    @GetMapping(params = "url")
    public List<ItemNoteDto> getItemNotesByUrl(@RequestHeader("X-Later-User-Id") Long userId,
                                               @RequestParam(name = "url") String url) {
        return itemNoteService.getItemNotesByUrl(userId, url);
    }

    @GetMapping(params = "tag")
    public List<ItemNoteDto> getItemNotesByTag(@RequestHeader("X-Later-User-Id") Long userId,
                                               @RequestParam(name = "tag") String tag) {
        return itemNoteService.getItemNotesByTag(userId, tag);
    }

    @GetMapping
    public List<ItemNoteDto> listAllItemsWithNotes(@RequestHeader("X-Later-User-Id") Long userId,
                                                   @RequestParam(name = "from", defaultValue = "0") Integer from,
                                                   @RequestParam(name = "size", defaultValue = "10") Integer size) {
        return itemNoteService.listAllItemsWithNotes(userId, from, size);
        // возвращает набор пользовательских заметок, соответствующий указанным параметрам пагинации
    }

    @PostMapping
    public ItemNoteDto addNewItemNote(@RequestHeader("X-Later-User-Id") Long userId,
                                      @RequestBody ItemNoteDto itemNoteDto) {
        return itemNoteService.addNewItemNote(userId, itemNoteDto);
    }

}
