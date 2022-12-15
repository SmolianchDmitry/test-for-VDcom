package vdcomtest.converter.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Entity {
    String name;
    Double conversionFactor;

    @Override
    public String toString() {
        return conversionFactor + " " + name;
    }
}
