package com.housing.market.form;

import com.housing.market.dto.Region;
import com.housing.market.dto.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Setter
@Getter
public class QueryParamsForm {
    private Region regionId;
    private Size size;
    private Integer rooms;
    private String types;

    @DateTimeFormat(pattern = "yyyyMMdd")
    private LocalDate dateSince;

    @DateTimeFormat(pattern = "yyyyMMdd")
    private LocalDate dateUntil;

}
