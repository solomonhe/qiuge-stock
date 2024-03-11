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
import com.qiuge.stock.domain.SwTradeLevel;
import com.qiuge.stock.service.ISwTradeLevelService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 申万行业等级关系Controller
 * 
 * @author qiuge
 * @date 2024-03-11
 */
@RestController
@RequestMapping("/stock/level")
public class SwTradeLevelController extends BaseController
{
    @Autowired
    private ISwTradeLevelService swTradeLevelService;

    /**
     * 查询申万行业等级关系列表
     */
    @PreAuthorize("@ss.hasPermi('stock:level:list')")
    @GetMapping("/list")
    public TableDataInfo list(SwTradeLevel swTradeLevel)
    {
        startPage();
        List<SwTradeLevel> list = swTradeLevelService.selectSwTradeLevelList(swTradeLevel);
        return getDataTable(list);
    }

    /**
     * 导出申万行业等级关系列表
     */
    @PreAuthorize("@ss.hasPermi('stock:level:export')")
    @Log(title = "申万行业等级关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SwTradeLevel swTradeLevel)
    {
        List<SwTradeLevel> list = swTradeLevelService.selectSwTradeLevelList(swTradeLevel);
        ExcelUtil<SwTradeLevel> util = new ExcelUtil<SwTradeLevel>(SwTradeLevel.class);
        util.exportExcel(response, list, "申万行业等级关系数据");
    }

    /**
     * 获取申万行业等级关系详细信息
     */
    @PreAuthorize("@ss.hasPermi('stock:level:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(swTradeLevelService.selectSwTradeLevelById(id));
    }

    /**
     * 新增申万行业等级关系
     */
    @PreAuthorize("@ss.hasPermi('stock:level:add')")
    @Log(title = "申万行业等级关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SwTradeLevel swTradeLevel)
    {
        return toAjax(swTradeLevelService.insertSwTradeLevel(swTradeLevel));
    }

    /**
     * 修改申万行业等级关系
     */
    @PreAuthorize("@ss.hasPermi('stock:level:edit')")
    @Log(title = "申万行业等级关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SwTradeLevel swTradeLevel)
    {
        return toAjax(swTradeLevelService.updateSwTradeLevel(swTradeLevel));
    }

    /**
     * 删除申万行业等级关系
     */
    @PreAuthorize("@ss.hasPermi('stock:level:remove')")
    @Log(title = "申万行业等级关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(swTradeLevelService.deleteSwTradeLevelByIds(ids));
    }
}
