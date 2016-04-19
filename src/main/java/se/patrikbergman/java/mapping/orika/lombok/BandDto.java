package se.patrikbergman.java.mapping.orika.lombok;

import lombok.*;

/**
 * Orika seems to depend on a public all args constructor?
 */
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
@Value
public class BandDto {
    private String name;
    private String biography;
    private int rockScore;
}
