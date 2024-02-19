package com.housing.market;

import jakarta.persistence.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Market {
    @Id
    private Long id;
    @Enumerated
    private Region regionId;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String description;
    private Float area;
    private Integer rooms;
    private LocalDate marketDate;
    @PrePersist  void onPrePersist() { marketDate = LocalDate.now();}

    /**
    * Mapstruct mapper
    *
    */
    @Mapper
    public interface MarketMapper {
        MarketMapper INSTANCE = Mappers.getMapper(MarketMapper.class);
        List<Market> createFrom(List<MarketForm> marketForms);
    }

    public static List<Market> createFromForm(MarketDataForm marketDataForm) {
        return MarketMapper.INSTANCE.createFrom(marketDataForm.getData());
    }
}
