package com.qiuge.stock.openapi.sina;

/**
 * @Classname： SinaUrlConstant
 * @Description： 新浪请求URL常量
 * @Date： 2023/2/24 18:02
 * @Author： by QiuGe
 */
public interface SinaUrlConstant {
    /**
     * 新浪数据左导航栏接口,包括概念热门行业 申万行业
     * 申万行业
     */
    String SW_TRADE_URL = "http://vip.stock.finance.sina.com.cn/quotes_service/api/json_v2.php/Market_Center" +
            ".getHQNodes";

    /**
     * 获取申万行业下面所属股票
     * 第一条是模板
     * 第二条 插入请求多少页，具体请求那个行业
     * <p>
     * 模板  http://vip.stock.finance.sina.com.cn/quotes_service/api/json_v2.php/Market_Center
     * .getHQNodeData?page=2&num=80&sort=symbol&asc=1&node=sw3_730202&symbol=&_s_r_a=page
     */
    String SW_TRADE_CODE_URL = "http://vip.stock.finance.sina.com.cn/quotes_service/api/json_v2.php/Market_Center" +
            ".getHQNodeData?page=%s&num=80&sort=symbol&asc=1&node=%s&symbol=&_s_r_a=page";


    /**
     * plate = sw1 申万一级行业
     * plate = sw2 申万二级行业
     * plate = sw3 申万三级行业
     * <p>
     * 新浪app端行业数据
     * <p>
     * 模板  https://quotes.sina.cn/hq/api/openapi.php/StockV2Service
     * .getPlateList?page=1&num=20&dpc=1&source=app&plate=sw1
     */
    String SW_APP_TRADE_URL = "https://quotes.sina.cn/hq/api/openapi.php/StockV2Service" +
            ".getPlateList?page=%s&num=80&dpc=1&source=app&plate=%s";


    /**
     * 新浪app端行业+股票 日行情 数据
     * <p>
     * 模板  https://quotes.sina.cn/moneyflow/api/openapi.php/Lv2_Service
     * .getCateKHistory?period=day&vtype=isymbol&len=3000&asc=0&cate=%s
     */
    String SW_APP_TRADE_PRICE_URL = "https://quotes.sina.cn/moneyflow/api/openapi.php/Lv2_Service" +
            ".getCateKHistory?period=day&vtype=isymbol&len=3000&asc=0&cate=%s";


    /**
     * 新浪app端行业+股票 分钟行情 数据
     * <p>
     * 模板  https://quotes.sina.cn/moneyflow/api/openapi.php/Lv2_Service
     * .getCateKHistory?period=day&vtype=isymbol&len=3000&asc=0&cate=%s
     */
    String SW_APP_TRADE_PRICE_MINUTE_URL = "https://quotes.sina.cn/cn/api/openapi.php/CN_MinlineService" +
            ".getMinlineData?symbol=%s&first_opentime=true";


    /**
     * A股全部股票实时行情
     */
    String STOCK_REAL_TIME = "https://vip.stock.finance.sina.com.cn/quotes_service/api/json_v2.php/Market_Center" +
            ".getHQNodeData?page=%s&num=80&sort=symbol&asc=1&node=hs_a&symbol=&_s_r_a=page";

}
