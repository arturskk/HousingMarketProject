package com.housing.market.mapper;

import com.housing.market.dto.Region;
import com.housing.market.dto.Type;
import com.housing.market.form.MarketForm;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

@UtilityClass
public class MarketFormCreator {

    public static MarketFormBuilder builder() {
        return new MarketFormBuilder();
    }

    public static class MarketFormBuilder extends MarketTestForm {

        public MarketFormBuilder id(String id) {
            this.id = id;
            return this;
        }

        public MarketFormBuilder regionId(Region regionId) {
            this.regionId = regionId;
            return this;
        }

        public MarketFormBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public MarketFormBuilder description(String description) {
            this.description = description;
            return this;
        }

        public MarketFormBuilder area(Float area) {
            this.area = area;
            return this;
        }

        public MarketFormBuilder rooms(Integer rooms) {
            this.rooms = rooms;
            return this;
        }

        public MarketFormBuilder type(Type type) {
            this.type = type;
            return this;
        }

        public MarketFormBuilder defaultValues() {

            return this.id("5d301374-f8f8-48c7-ac79-4e8e68659b39")
                    .regionId(Region.LUBL)
                    .area(70.25f)
                    .price(BigDecimal.valueOf(100000))
                    .description("Nice house")
                    .type(Type.DETACHED_HOUSE)
                    .rooms(4)
                    .type(Type.SEMI_DETACHED_HOUSE);
        }

        public MarketForm build() {
            MarketForm marketForm = new MarketForm();
            marketForm.setId(this.id);
            marketForm.setArea(this.area);
            marketForm.setRooms(this.rooms);
            marketForm.setRegionId(this.regionId);
            marketForm.setType(this.type);
            marketForm.setDescription(this.getDescription());
            marketForm.setPrice(this.price);
            return marketForm;
        }
    }
}
