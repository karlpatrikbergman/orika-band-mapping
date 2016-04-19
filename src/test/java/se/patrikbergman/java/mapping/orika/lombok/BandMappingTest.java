package se.patrikbergman.java.mapping.orika.lombok;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Slf4j
public class BandMappingTest {

    private BandMapper mapper;

    @Before
    public void setup() {
        mapper = BandMapper.INSTANCE;
    }

    @Test
    public void bandToBandDto() {
        Band band = Band.builder()
                .name("Judas Priest")
                .description("Judas Priest are a British heavy metal band formed in Birmingham, England, in 1969.")
                .rockFactor(8)
                .build();

        BandDto bandDto = mapper.bandToBandDto(band);

        assertNotNull(bandDto);
        assertEquals(band.getName(), bandDto.getName());
        assertEquals(band.getDescription(), bandDto.getBiography());
        assertEquals(band.getRockFactor(), bandDto.getRockScore());

        log.info(bandDto.toString());
    }

    @Test
    public void bandDtoToBand() {
        BandDto bandDto = BandDto.builder()
                .name("Judas Priest")
                .biography("Judas Priest are a British heavy metal band formed in Birmingham, England, in 1969.")
                .rockScore(8)
                .build();

        Band band = mapper.bantDtoToBand(bandDto);

        assertNotNull(band);
        assertEquals(bandDto.getName(), band.getName());
        assertEquals(bandDto.getBiography(), band.getDescription());
        assertEquals(bandDto.getRockScore(), band.getRockFactor());

        log.info(band.toString());
    }
}
