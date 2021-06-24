package com.neuedu.his.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Courier;
import com.neuedu.his.entity.Site;
import com.neuedu.his.service.ICourierService;
import com.neuedu.his.service.impl.CourierServiceImpl;
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
 * 快递员管理
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/courier")
public class CourierController {
    @Resource
    ICourierService courierService;

    @RequestMapping("/list")
    CommonResult page(Page page, Courier courier){
        QueryWrapper<Courier> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("active",1);
        return CommonResult.success(courierService.pageList(page,courier));
    }


    @RequestMapping("save")
    @ResponseBody
    CommonResult save(Courier courier){

        return  CommonResult.success(courierService.saveOrUpdate(courier));
    }
    @RequestMapping("getByName")
    CommonResult getByCourierName(String  courierName){

        return CommonResult.success(courierService.getById(courierName));
    }

    @RequestMapping("getById")
    CommonResult getById(String  courierId){

        return CommonResult.success(courierService.getById(courierId));
    }


    @RequestMapping("toedit")
    @ResponseBody
    CommonResult toedit(Courier courier){

        return CommonResult.success(courierService.updateById(courier));
    }

    @RequestMapping("del/{courierId}")
    @ResponseBody
    CommonResult delete(@PathVariable String courierId){

        return  CommonResult.success(courierService.removeById(courierId));    }

    @RequestMapping("/batchdel")
    CommonResult batchdel( String[] ids){

        return CommonResult.success(courierService.removeByIds(Arrays.asList(ids)));

    }

}
