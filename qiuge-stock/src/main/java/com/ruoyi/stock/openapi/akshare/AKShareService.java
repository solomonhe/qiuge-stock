package com.ruoyi.stock.openapi.akshare;

import java.util.List;

/**
 * @description:
 * @author: Solomon
 * <p>Copyright；Copyright (c) 2024</p>
 * @date: 2024-01-14 14:21
 * @version: 1.0
 **/
public interface AKShareService {

    /**
    *   获取A股交易日期
    *@author: Solomon
    */
    List<Integer> getTreadDateA();
}
