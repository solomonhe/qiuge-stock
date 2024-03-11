package com.qiuge.stock.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.qiuge.stock.domain.StockTradeDate;
import com.qiuge.stock.service.IStockTradeDateService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 上交所/深交所交易日期Controller
 * 
 * @author qiuge
 * @date 2024-03-11
 */
@RestController
@RequestMapping("/stock/date")
public class StockTradeDateController extends BaseController
{
    @Autowired
    private IStockTradeDateService stockTradeDateService;

    /**
     * 查询上交所/深交所交易日期列表
     */
    @PreAuthorize("@ss.hasPermi('stock:date:list')")
    @GetMapping("/list")
    public TableDataInfo list(StockTradeDate stockTradeDate)
    {
        startPage();
        List<StockTradeDate> list = stockTradeDateService.selectStockTradeDateList(stockTradeDate);
        return getDataTable(list);
    }

    /**
     * 导出上交所/深交所交易日期列表
     */
    @PreAuthorize("@ss.hasPermi('stock:date:export')")
    @Log(title = "上交所/深交所交易日期", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StockTradeDate stockTradeDate)
    {
        List<StockTradeDate> list = stockTradeDateService.selectStockTradeDateList(stockTradeDate);
        ExcelUtil<StockTradeDate> util = new ExcelUtil<StockTradeDate>(StockTradeDate.class);
        util.exportExcel(response, list, "上交所/深交所交易日期数据");
    }

    /**
     * 获取上交所/深交所交易日期详细信息
     */
    @PreAuthorize("@ss.hasPermi('stock:date:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(stockTradeDateService.selectStockTradeDateById(id));
    }

    /**
     * 新增上交所/深交所交易日期
     */
    @PreAuthorize("@ss.hasPermi('stock:date:add')")
    @Log(title = "上交所/深交所交易日期", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StockTradeDate stockTradeDate)
    {
        return toAjax(stockTradeDateService.insertStockTradeDate(stockTradeDate));
    }

    /**
     * 修改上交所/深交所交易日期
     */
    @PreAuthorize("@ss.hasPermi('stock:date:edit')")
    @Log(title = "上交所/深交所交易日期", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StockTradeDate stockTradeDate)
    {
        return toAjax(stockTradeDateService.updateStockTradeDate(stockTradeDate));
    }

    /**
     * 删除上交所/深交所交易日期
     */
    @PreAuthorize("@ss.hasPermi('stock:date:remove')")
    @Log(title = "上交所/深交所交易日期", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(stockTradeDateService.deleteStockTradeDateByIds(ids));
    }
}
