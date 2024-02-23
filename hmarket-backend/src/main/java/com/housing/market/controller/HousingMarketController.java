package com.housing.market.controller;

import com.housing.market.api.HousingMarketApi;
import com.housing.market.dto.Region;
import com.housing.market.dto.StatsDto;
import com.housing.market.form.QueryParamsForm;
import com.housing.market.housing.MarketService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class HousingMarketController implements HousingMarketApi {

    private final MarketService marketService;

    @Operation(summary = "get real estates average price")
    @GetMapping(path = "/real-estates-stats/{regionId}", produces="application/json")
    public StatsDto getRealEstatesStats(@PathVariable Region regionId, QueryParamsForm queryParamsForm) {
        return marketService.getMarketStats(regionId, queryParamsForm);
    }
}
