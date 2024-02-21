package com.housing.market.domain;

import com.housing.market.dto.Region;
import com.housing.market.dto.Type;
import com.housing.market.form.MarketDataForm;
import com.housing.market.form.MarketForm;
import jakarta.persistence.*;
import lombok.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
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
        @Mapping(target = "id", ignore = true)
        @Mapping(target = "marketDate", ignore = true)
        Market toEntity(MarketForm value);
    }

    public static List<Market> createFromForm(MarketDataForm marketDataForm) {
        return MarketMapper.INSTANCE.createFrom(marketDataForm.getData());
    }
}
