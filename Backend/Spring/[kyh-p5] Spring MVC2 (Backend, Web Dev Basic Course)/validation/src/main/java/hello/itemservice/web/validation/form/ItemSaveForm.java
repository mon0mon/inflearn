package hello.itemservice.web.validation.form;

import hello.itemservice.domain.item.SaveCheck;
import hello.itemservice.domain.item.UpdateCheck;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class ItemSaveForm {

  @NotBlank
  private String itemName;
  @NotNull
  @Range(min = 1_000, max = 1_000_000)
  private Integer price;
  @NotNull
  @Max(value = 9_999)
  private Integer quantity;

}
