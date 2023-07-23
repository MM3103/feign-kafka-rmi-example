package common.dto.patterns.iterator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    String name;
    Integer cost;
    Integer weight;
}
