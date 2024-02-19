package com.housing.market.mock;
public enum Region {

    DLN_WROC_C("Dolnośląskie - Wrocław centrum"),
    DLN_WROC_PC("Dolnośląskie - Wrocław poza centrum"),
    DLN_POZA_WROC("Dolnośląskie - poza Wrocławiem"),
    SL_POL("Śląskie - południe"),
    SL_KATO("Śląskie - Katowice"),
    SL_PN("Śląskie - północ"),
    M_WAW_CE("Mazowieckie - Warszawa Centrum"),
    M_WAW_W("Mazowieckie - Warszawa wschód"),
    M_WAW_Z("Mazowieckie - Warszaawa - zachód"),
    LUBL("Lubelskie - Lublin"),
    LUBL_INNE("Lubelskie - poza Lublinem"),
    ZPOM("Zachodniopomorskie"),
    LUBSK("Lubuskie");

    Region(String region) {
        this.region = region;
    }

    private final String region;
}
