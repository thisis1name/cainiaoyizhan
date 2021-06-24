package com.neuedu.his.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Company;
import com.neuedu.his.entity.Qrcode;
import com.neuedu.his.service.IQrcodeService;
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
 *  客户订单管理
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/order")
public class QrcodeController {
    @Resource
    IQrcodeService orderService;

    @RequestMapping("/plist")
    @ResponseBody
    CommonResult findAllOrder(){
        List<Qrcode> list = orderService.list(null);
        return CommonResult.success(list);
    }

    @RequestMapping("list")
    CommonResult page(Page page, Qrcode order){

        return CommonResult.success(orderService.pageList(page,order));
    }
    @RequestMapping("save")
    @ResponseBody
    CommonResult save(Qrcode order){

        return  CommonResult.success(orderService.saveOrUpdate(order));
    }


    @RequestMapping("getById")
    CommonResult getById(String  id){

        return CommonResult.success(orderService.getById(id));
    }


    @RequestMapping("toedit")
    @ResponseBody
    CommonResult toedit(Qrcode order){
//        order.setCreatetime(null);

        return CommonResult.success(orderService.updateById(order));
    }

    @RequestMapping("del/{id}")
    @ResponseBody
    CommonResult delete(@PathVariable String id){

        return  CommonResult.success(orderService.removeById(id));
    }
    @RequestMapping("/batchdel")
    CommonResult batchdel(String[] ids){
        System.out.println(ids);
        return CommonResult.success(orderService.removeByIds(Arrays.asList(ids)));

    }

}
