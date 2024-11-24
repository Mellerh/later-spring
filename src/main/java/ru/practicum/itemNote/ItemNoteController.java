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

    @GetMapping(name = "tag")
    public List<ItemNoteDto> getItemNotesByTag(@RequestHeader("X-Later-User-Id") Long userId,
                                               @RequestParam(name = "tag") String tag) {
        return itemNoteService.getItemNotesByTag(userId, tag);
    }

}
