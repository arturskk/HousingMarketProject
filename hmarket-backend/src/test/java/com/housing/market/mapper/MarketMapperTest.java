package com.housing.market.mapper;

import com.housing.market.creator.MarketFormCreator;
import com.housing.market.domain.Market;
import com.housing.market.form.MarketForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MarketMapperTest {
    Market.MarketMapper marketMapper = Market.MarketMapper.INSTANCE;

    @Test
     void formToEntityMarket() {
        MarketForm marketForm = MarketFormCreator.builder().defaultValues().build();
        Market market = marketMapper.toEntity(marketForm);

        Assertions.assertEquals(marketForm.getArea(), market.getArea());
        Assertions.assertEquals(marketForm.getDescription(), market.getDescription());
        Assertions.assertEquals(marketForm.getRooms(), market.getRooms());
        Assertions.assertEquals(marketForm.getRegionId(), market.getRegionId());
        Assertions.assertEquals(marketForm.getPrice(), market.getPrice());
        Assertions.assertEquals(marketForm.getType(), market.getType());
    }
}
