package com.housing.market;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
@Setter
@Getter
public class QueryParamsForm {
    private Region regionId;
    private Size size;
    private Integer rooms;
    private String types;

    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date dateSince;

    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date dateUntil;

}
