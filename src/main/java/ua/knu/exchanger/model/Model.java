package ua.knu.exchanger.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Model {
    private String data;
}
