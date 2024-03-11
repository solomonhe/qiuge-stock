package com.qiuge.stock.openapi.akshare.constant;

import lombok.Getter;

public enum InterfaceEnum {

    TOOL_TRADE_DATE_HIST_SINA("tool_trade_date_hist_sina", "A股交易日历"),

    ;

    @Getter
    private String url;
    @Getter
    private String urlDoc;

    InterfaceEnum(String url, String urlDoc) {
        this.url = url;
        this.urlDoc = urlDoc;
    }
}
