package com.neuedu.his.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Goods;
import com.neuedu.his.entity.Shelf;
import com.neuedu.his.service.IShelfService;
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
@RequestMapping("/shelf")
public class ShelfController {
    @Resource
    IShelfService iShelfService;
    @RequestMapping("/list")
    CommonResult page(Page page, Shelf shelf){
        return CommonResult.success(iShelfService.pageList(page,shelf));
    }

    @RequestMapping("save")
    @ResponseBody
    CommonResult save(Shelf shelf){

        return  CommonResult.success(iShelfService.saveOrUpdate(shelf));
    }


    @RequestMapping("getById")
    CommonResult getById(String  id){

        return CommonResult.success(iShelfService.getById(id));
    }


    @RequestMapping("edit")
    @ResponseBody
    CommonResult edit(Shelf shelf){

        return CommonResult.success(iShelfService.updateById(shelf));
    }

    @RequestMapping("del/{id}")
    @ResponseBody
    CommonResult delete(@PathVariable String id){

        return  CommonResult.success(iShelfService.removeById(id));
    }

    @RequestMapping("/batchdel")
    CommonResult batchdel(String[] ids){
        System.out.println(ids);
        return CommonResult.success(iShelfService.removeByIds(Arrays.asList(ids)));

    }



}
