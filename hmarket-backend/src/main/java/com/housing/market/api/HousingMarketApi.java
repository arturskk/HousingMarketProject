package com.housing.market.api;

import com.housing.market.dto.Region;
import com.housing.market.dto.StatsDto;
import com.housing.market.form.QueryParamsForm;
import org.springframework.web.bind.annotation.PathVariable;

public interface HousingMarketApi {
    public StatsDto getRealEstatesStats(@PathVariable Region regionId, QueryParamsForm queryParamsForm);
}
