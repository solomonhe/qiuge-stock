package com.qiuge.stock.openapi.xueqiu;

/**
 * @Classname： XueQiuUrlConstant
 * @Description： 雪球请求URL常量
 * @Date： 2023/2/24 18:02
 * @Author： by QiuGe
 */
public interface XueQiuUrlConstant {

    /**
     * 获取股票当天信息URL
     */
    String codeDayInfoUrl = "https://stock.xueqiu.com/v5/stock/quote.json?symbol=%s&extend=detail";

    /**
     * 获取股票当天成交均价
     */
    String stockAvgPrice = "https://stock.xueqiu.com/v5/stock/quote.json?symbol=%s&extend=detail";

    /**
     * 均线URL
     */
    String maInfoUrl = "https://stock.xueqiu.com/v5/stock/chart/kline.json?symbol=SZ300653&begin=1652086212527&period=day&type=before&count=-284&indicator=kline,pe,pb,ps,pcf,market_capital,agt,ggt,balance";
}
