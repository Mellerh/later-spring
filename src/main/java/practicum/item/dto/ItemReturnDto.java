package practicum.item.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class ItemReturnDto {

    private Long userId;
    private String url;

}
