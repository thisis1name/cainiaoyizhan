package com.neuedu.his.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Goods;
import com.neuedu.his.entity.Site;
import com.neuedu.his.service.IGoodsService;
import com.neuedu.his.util.CommonResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 刘佳
 * @since 2021-07-02
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    IGoodsService goodsService;

    @RequestMapping("/list")
    CommonResult page(Page page, Goods goods){
        return CommonResult.success(goodsService.pageList(page,goods));
    }

    @RequestMapping("save")
    @ResponseBody
    CommonResult save(Goods goods){

        return  CommonResult.success(goodsService.saveOrUpdate(goods));
    }


    @RequestMapping("getById")
    CommonResult getById(String  id){

        return CommonResult.success(goodsService.getById(id));
    }


    @RequestMapping("edit")
    @ResponseBody
    CommonResult edit(Goods goods){

        return CommonResult.success(goodsService.updateById(goods));
    }

    @RequestMapping("del/{id}")
    @ResponseBody
    CommonResult delete(@PathVariable String id){

        return  CommonResult.success(goodsService.removeById(id));
    }

    @RequestMapping("/batchdel")
    CommonResult batchdel(String[] ids){
        System.out.println(ids);
        return CommonResult.success(goodsService.removeByIds(Arrays.asList(ids)));

    }

}
