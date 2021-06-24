package com.neuedu.his.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Collect;
import com.neuedu.his.entity.Site;
import com.neuedu.his.service.ICollectService;
import com.neuedu.his.util.CommonResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * <p>
 *  揽件管理
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/collect")
public class CollectController {
    @Resource
    ICollectService collectService;

    @RequestMapping("/list")
    CommonResult page(Page page, Collect collect){
        return CommonResult.success(collectService.pageList(page,collect));
    }

    @RequestMapping("save")
    @ResponseBody
    CommonResult save(Collect collect){

        collect.setStatus("已揽件");
        return  CommonResult.success(collectService.updateById(collect));
    }

    @RequestMapping("save1")
    @ResponseBody
    CommonResult save1(Collect collect){


        return  CommonResult.success(collectService.saveOrUpdate(collect));
    }

    @RequestMapping("getById")
    CommonResult getById(String  id){

        return CommonResult.success(collectService.getById(id));
    }


    @RequestMapping("edit")
    @ResponseBody
    CommonResult edit(Collect collect){

        return CommonResult.success(collectService.updateById(collect));
    }

    @RequestMapping("del/{id}")
    @ResponseBody
    CommonResult delete(@PathVariable String id){

        return  CommonResult.success(collectService.removeById(id));
    }

    @RequestMapping("/batchdel")
    CommonResult batchdel(String[] ids){
        System.out.println(ids);
        return CommonResult.success(collectService.removeByIds(Arrays.asList(ids)));

    }

}
