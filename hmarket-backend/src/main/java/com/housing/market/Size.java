package com.housing.market;
public enum Size {
    S(18,45),
    M(46,80),
    L(81,400);

    final Integer rangeMin;
    final Integer rangeMax;

    Size(Integer rangeMin, Integer rangeMax) {
        this.rangeMin = rangeMin;
        this.rangeMax = rangeMax;
    }


}
