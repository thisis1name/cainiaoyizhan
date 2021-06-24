package com.neuedu.his.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Company;
import com.neuedu.his.entity.Orderscan;
import com.neuedu.his.service.IOrderscanService;
import com.neuedu.his.util.CommonResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  订单扫描
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/orderscan")
public class OrderscanController {

    @Resource
    IOrderscanService orderscanService;

    @RequestMapping("/plist")
    @ResponseBody
    CommonResult findAllOrderScan(){
        List<Orderscan> list = orderscanService.list(null);
        return CommonResult.success(list);
    }

    @RequestMapping("/list")
    CommonResult page(Page page, Orderscan orderscan){
        return CommonResult.success(orderscanService.pageList(page,orderscan));
    }

    @RequestMapping("save")
    @ResponseBody
    CommonResult save(Orderscan orderscan){

        return  CommonResult.success(orderscanService.saveOrUpdate(orderscan));
    }


    @RequestMapping("getById")
    CommonResult getById(String  id){

        return CommonResult.success(orderscanService.getById(id));
    }


    @RequestMapping("edit")
    @ResponseBody
    CommonResult edit(Orderscan orderscan){

        return CommonResult.success(orderscanService.updateById(orderscan));
    }

    @RequestMapping("del/{id}")
    @ResponseBody
    CommonResult delete(@PathVariable String id){

        return  CommonResult.success(orderscanService.removeById(id));
    }
    @RequestMapping("/batchdel")
    CommonResult batchdel(String[] ids){
        System.out.println(ids);
        return CommonResult.success(orderscanService.removeByIds(Arrays.asList(ids)));

    }

}
