package com.neuedu.his.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Site;
import com.neuedu.his.service.ISiteService;
import com.neuedu.his.util.CommonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  站点管理
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/site")
public class SiteController {
    @Resource
    ISiteService siteService;

    @RequestMapping("/plist")
    @ResponseBody
    CommonResult findAllCompany(){
        List<Site> list = siteService.list(null);
        return CommonResult.success(list);
    }

    @RequestMapping("/list")
    CommonResult page(Page page, Site site){
        return CommonResult.success(siteService.pageList(page,site));
    }

    @RequestMapping("save")
    @ResponseBody
    CommonResult save(Site site){

        return  CommonResult.success(siteService.saveOrUpdate(site));
    }
    @RequestMapping("getByName")
    CommonResult getBySiteName(String  sitename){

        return CommonResult.success(siteService.getById(sitename));
    }

    @RequestMapping("getById")
    CommonResult getById(String  siteId){

        return CommonResult.success(siteService.getById(siteId));
    }


    @RequestMapping("toedit")
    @ResponseBody
    CommonResult toedit(Site site){

        return CommonResult.success(siteService.updateById(site));
    }

    @RequestMapping("del/{Id}")
    @ResponseBody
    CommonResult delete(@PathVariable String Id){

        return  CommonResult.success(siteService.removeById(Id));
    }
    @RequestMapping("/batchdel")
    CommonResult batchdel(String[] ids){

        return CommonResult.success(siteService.removeByIds(Arrays.asList(ids)));
    }




}
