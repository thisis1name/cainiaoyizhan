package com.neuedu.his.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Customer;
import com.neuedu.his.entity.Site;
import com.neuedu.his.service.ICustomerService;
import com.neuedu.his.util.CommonResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * <p>
 *  客户管理
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    ICustomerService customerService;

    @RequestMapping("/list")
    CommonResult page(Page page, Customer customer){
        return CommonResult.success(customerService.pageList(page,customer));
    }

    @RequestMapping("save")
    @ResponseBody
    CommonResult save(Customer customer){

        return  CommonResult.success(customerService.saveOrUpdate(customer));
    }

    @RequestMapping("getById")
    CommonResult getById(String  customerName){

        return CommonResult.success(customerService.getById(customerName));
    }


    @RequestMapping("toedit")
    @ResponseBody
    CommonResult toedit(Customer customer){

        return CommonResult.success(customerService.updateById(customer));
    }

    @RequestMapping("del/{customerName}")
    @ResponseBody
    CommonResult delete(@PathVariable String customerName){

        return  CommonResult.success(customerService.removeById(customerName));
    }

    @RequestMapping("/batchdel")
    CommonResult batchdel(String[] ids){

        return CommonResult.success(customerService.removeByIds(Arrays.asList(ids)));
    }


}
