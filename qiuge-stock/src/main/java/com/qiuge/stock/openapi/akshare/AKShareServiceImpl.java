package com.qiuge.stock.openapi.akshare;

import com.qiuge.stock.openapi.akshare.bean.TreadDate;
import com.qiuge.stock.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: AkShare实现类
 * @author: Solomon
 * <p>Copyright；Copyright (c) 2024</p>
 * @date: 2024-01-14 14:21
 * @version: 1.0
 **/

@Service("aKShareService")
public class AKShareServiceImpl implements AKShareService {

    @Autowired
    private AKShareBaseHttp shareBaseHttp;

    @Override
    public List<Integer> getTreadDateA() {
        List<TreadDate> treadDates = shareBaseHttp.treadDataA();
        return treadDates.stream().map(treadDate -> {
            int dateNum = DateUtils.formatTime(treadDate.getTradeDate(), DateUtils.DATEPATTERN).intValue();
            return dateNum;
        }).collect(Collectors.toList());
    }
}
