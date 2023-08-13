package common.dto.patterns.iterator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food implements Serializable {
    String name;
    Integer cost;
    Integer weight;
}
