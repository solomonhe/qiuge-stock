package com.ruoyi;


import com.qiuge.stock.domain.Stock;
import com.qiuge.stock.service.IStockService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


/**
 * @author Solomon
 * @date 2020/8/4 15:59
 */
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoTest {

    @Resource
    private IStockService stockService;

    @Test
    public void test()  {
        final Stock stock = stockService.selectStockById("1111");
        log.info("stock:{}", stock);
    }
}
