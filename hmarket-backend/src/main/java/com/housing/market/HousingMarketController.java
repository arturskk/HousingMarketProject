package com.housing.market;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class HousingMarketController {

    private final MarketService marketService;
    @GetMapping(path = "/real-estates-stats/{regionId}" )
    public StatsDto getRealEstatesStats(@PathVariable Region regionId, QueryParamsForm queryParamsForm) {
        return marketService.getMarketStats(queryParamsForm);
    }
}
