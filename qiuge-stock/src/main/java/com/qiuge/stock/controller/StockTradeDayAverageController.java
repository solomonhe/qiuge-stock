package com.qiuge.stock.controller;

import com.qiuge.stock.domain.StockTradeDayAverage;
import com.qiuge.stock.service.IStockTradeDayAverageService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * A股股票每日均价成交Controller
 * 
 * @author qiuge
 * @date 2024-03-11
 */
@RestController
@RequestMapping("/stock/average")
public class StockTradeDayAverageController extends BaseController
{
    @Autowired
    private IStockTradeDayAverageService stockTradeDayAverageService;

    /**
     * 查询A股股票每日均价成交列表
     */
    @PreAuthorize("@ss.hasPermi('stock:average:list')")
    @GetMapping("/list")
    public TableDataInfo list(StockTradeDayAverage stockTradeDayAverage)
    {
        startPage();
        List<StockTradeDayAverage> list = stockTradeDayAverageService.selectStockTradeDayAverageList(stockTradeDayAverage);
        return getDataTable(list);
    }

    /**
     * 导出A股股票每日均价成交列表
     */
    @PreAuthorize("@ss.hasPermi('stock:average:export')")
    @Log(title = "A股股票每日均价成交", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StockTradeDayAverage stockTradeDayAverage)
    {
        List<StockTradeDayAverage> list = stockTradeDayAverageService.selectStockTradeDayAverageList(stockTradeDayAverage);
        ExcelUtil<StockTradeDayAverage> util = new ExcelUtil<StockTradeDayAverage>(StockTradeDayAverage.class);
        util.exportExcel(response, list, "A股股票每日均价成交数据");
    }

    /**
     * 获取A股股票每日均价成交详细信息
     */
    @PreAuthorize("@ss.hasPermi('stock:average:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(stockTradeDayAverageService.selectStockTradeDayAverageById(id));
    }

    /**
     * 新增A股股票每日均价成交
     */
    @PreAuthorize("@ss.hasPermi('stock:average:add')")
    @Log(title = "A股股票每日均价成交", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StockTradeDayAverage stockTradeDayAverage)
    {
        return toAjax(stockTradeDayAverageService.insertStockTradeDayAverage(stockTradeDayAverage));
    }

    /**
     * 修改A股股票每日均价成交
     */
    @PreAuthorize("@ss.hasPermi('stock:average:edit')")
    @Log(title = "A股股票每日均价成交", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StockTradeDayAverage stockTradeDayAverage)
    {
        return toAjax(stockTradeDayAverageService.updateStockTradeDayAverage(stockTradeDayAverage));
    }

    /**
     * 删除A股股票每日均价成交
     */
    @PreAuthorize("@ss.hasPermi('stock:average:remove')")
    @Log(title = "A股股票每日均价成交", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(stockTradeDayAverageService.deleteStockTradeDayAverageByIds(ids));
    }
}
