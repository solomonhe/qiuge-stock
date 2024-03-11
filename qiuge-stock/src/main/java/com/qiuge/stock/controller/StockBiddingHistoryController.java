package com.qiuge.stock.controller;

import com.qiuge.stock.domain.StockBiddingHistory;
import com.qiuge.stock.service.IStockBiddingHistoryService;
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
 * 竞价历史Controller
 * 
 * @author qiuge
 * @date 2024-03-11
 */
@RestController
@RequestMapping("/stock/history")
public class StockBiddingHistoryController extends BaseController
{
    @Autowired
    private IStockBiddingHistoryService stockBiddingHistoryService;

    /**
     * 查询竞价历史列表
     */
    @PreAuthorize("@ss.hasPermi('stock:history:list')")
    @GetMapping("/list")
    public TableDataInfo list(StockBiddingHistory stockBiddingHistory)
    {
        startPage();
        List<StockBiddingHistory> list = stockBiddingHistoryService.selectStockBiddingHistoryList(stockBiddingHistory);
        return getDataTable(list);
    }

    /**
     * 导出竞价历史列表
     */
    @PreAuthorize("@ss.hasPermi('stock:history:export')")
    @Log(title = "竞价历史", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StockBiddingHistory stockBiddingHistory)
    {
        List<StockBiddingHistory> list = stockBiddingHistoryService.selectStockBiddingHistoryList(stockBiddingHistory);
        ExcelUtil<StockBiddingHistory> util = new ExcelUtil<StockBiddingHistory>(StockBiddingHistory.class);
        util.exportExcel(response, list, "竞价历史数据");
    }

    /**
     * 获取竞价历史详细信息
     */
    @PreAuthorize("@ss.hasPermi('stock:history:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(stockBiddingHistoryService.selectStockBiddingHistoryById(id));
    }

    /**
     * 新增竞价历史
     */
    @PreAuthorize("@ss.hasPermi('stock:history:add')")
    @Log(title = "竞价历史", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StockBiddingHistory stockBiddingHistory)
    {
        return toAjax(stockBiddingHistoryService.insertStockBiddingHistory(stockBiddingHistory));
    }

    /**
     * 修改竞价历史
     */
    @PreAuthorize("@ss.hasPermi('stock:history:edit')")
    @Log(title = "竞价历史", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StockBiddingHistory stockBiddingHistory)
    {
        return toAjax(stockBiddingHistoryService.updateStockBiddingHistory(stockBiddingHistory));
    }

    /**
     * 删除竞价历史
     */
    @PreAuthorize("@ss.hasPermi('stock:history:remove')")
    @Log(title = "竞价历史", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(stockBiddingHistoryService.deleteStockBiddingHistoryByIds(ids));
    }
}
