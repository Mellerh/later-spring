package practicum.item.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class ItemCreateDto {

    private Long userId;
    private String url;

}
