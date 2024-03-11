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
import com.qiuge.stock.domain.StockTradeDayInfo;
import com.qiuge.stock.service.IStockTradeDayInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * A股股票交易信息Controller
 * 
 * @author qiuge
 * @date 2024-03-11
 */
@RestController
@RequestMapping("/stock/info")
public class StockTradeDayInfoController extends BaseController
{
    @Autowired
    private IStockTradeDayInfoService stockTradeDayInfoService;

    /**
     * 查询A股股票交易信息列表
     */
    @PreAuthorize("@ss.hasPermi('stock:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(StockTradeDayInfo stockTradeDayInfo)
    {
        startPage();
        List<StockTradeDayInfo> list = stockTradeDayInfoService.selectStockTradeDayInfoList(stockTradeDayInfo);
        return getDataTable(list);
    }

    /**
     * 导出A股股票交易信息列表
     */
    @PreAuthorize("@ss.hasPermi('stock:info:export')")
    @Log(title = "A股股票交易信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StockTradeDayInfo stockTradeDayInfo)
    {
        List<StockTradeDayInfo> list = stockTradeDayInfoService.selectStockTradeDayInfoList(stockTradeDayInfo);
        ExcelUtil<StockTradeDayInfo> util = new ExcelUtil<StockTradeDayInfo>(StockTradeDayInfo.class);
        util.exportExcel(response, list, "A股股票交易信息数据");
    }

    /**
     * 获取A股股票交易信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('stock:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(stockTradeDayInfoService.selectStockTradeDayInfoById(id));
    }

    /**
     * 新增A股股票交易信息
     */
    @PreAuthorize("@ss.hasPermi('stock:info:add')")
    @Log(title = "A股股票交易信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StockTradeDayInfo stockTradeDayInfo)
    {
        return toAjax(stockTradeDayInfoService.insertStockTradeDayInfo(stockTradeDayInfo));
    }

    /**
     * 修改A股股票交易信息
     */
    @PreAuthorize("@ss.hasPermi('stock:info:edit')")
    @Log(title = "A股股票交易信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StockTradeDayInfo stockTradeDayInfo)
    {
        return toAjax(stockTradeDayInfoService.updateStockTradeDayInfo(stockTradeDayInfo));
    }

    /**
     * 删除A股股票交易信息
     */
    @PreAuthorize("@ss.hasPermi('stock:info:remove')")
    @Log(title = "A股股票交易信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(stockTradeDayInfoService.deleteStockTradeDayInfoByIds(ids));
    }
}
