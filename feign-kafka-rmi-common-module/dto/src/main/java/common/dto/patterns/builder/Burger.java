package common.dto.patterns.builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Burger {

    private String bun;
    private String cutlet;
    private String sauce;
    private String cheese;

}
