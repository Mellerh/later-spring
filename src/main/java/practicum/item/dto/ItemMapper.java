package practicum.item.dto;

import org.springframework.stereotype.Component;
import practicum.item.Item;

@Component
public class ItemMapper {

    public Item toItemModel(ItemCreateDto itemDto) {
        return Item.builder()
                .userId(itemDto.getUserId())
                .url(itemDto.getUrl())
                .build();
    }

    public ItemReturnDto toItemDto(Item item) {
        return ItemReturnDto.builder()
                .userId(item.getUserId())
                .url(item.getUrl())
                .build();
    }

}
