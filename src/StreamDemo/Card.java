package StreamDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private String size;//牌的数字
    private String color;//花色
    private int num;//大小

    @Override
    public String toString() {
        return size + color;
    }

}
