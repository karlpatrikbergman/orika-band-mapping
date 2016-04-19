package se.patrikbergman.java.mapping.orika.lombok;

import lombok.*;

/**
 * Orika seems to depend on a public all args constructor?
 */
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
@Value
public class Band {
    private String name;
    private String description;
    private int rockFactor;
}
