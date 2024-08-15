package hello.itemservice.domain.item;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class Item {

    @NotNull    // 수정 요구사항 추가
    private Long id;
    @NotBlank(message = "공백X")
    private String itemName;
    @NotNull
    @Range(min = 1_000, max = 1_000_000)
    private Integer price;
    @NotNull
//    @Max(9_999)   // 수정 요구사항 추가
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
