package se.patrikbergman.java.mapping.orika.lombok;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;


public enum BandMapper {
    INSTANCE;
    private static final BoundMapperFacade<Band, BandDto> boundMapper;

    static {
        final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Band.class, BandDto.class)
                .field("description", "biography")
                .field("rockFactor", "rockScore")
                .byDefault().register();
        boundMapper = mapperFactory.getMapperFacade(Band.class, BandDto.class);
    }

    public BandDto bandToBandDto(Band band) {
        return boundMapper.map(band);
    }

    public Band bantDtoToBand(BandDto bandDto) {
        return boundMapper.mapReverse(bandDto);
    }
}
