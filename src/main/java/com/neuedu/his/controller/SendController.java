package com.neuedu.his.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Send;
import com.neuedu.his.entity.Site;
import com.neuedu.his.service.ISendService;
import com.neuedu.his.util.CommonResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Random;

/**
 * <p>
 *  派件管理
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/send")
public class SendController {
    @Resource
    ISendService sendService;

    @RequestMapping("/list")
    CommonResult page(Page page, Send send){

        return CommonResult.success(sendService.pageList(page,send));
    }

    @RequestMapping("save")
    @ResponseBody
    CommonResult save(Send send){

        send.setStatus("已发送");
        return  CommonResult.success(sendService.updateById(send));
    }

    @RequestMapping("save1")
    @ResponseBody
    CommonResult save1(Send send){

        return  CommonResult.success(sendService.saveOrUpdate(send));
    }


    @RequestMapping("getById")
    CommonResult getById(String  id){

        return CommonResult.success(sendService.getById(id));
    }


    @RequestMapping("edit")
    @ResponseBody
    CommonResult toedit(Send send){


        return CommonResult.success(sendService.updateById(send));
    }

    @RequestMapping("del/{id}")
    @ResponseBody
    CommonResult delete(@PathVariable String id){

        return  CommonResult.success(sendService.removeById(id));
    }

    @RequestMapping("/batchdel")
    CommonResult batchdel(String[] ids){
        System.out.println(ids);
        return CommonResult.success(sendService.removeByIds(Arrays.asList(ids)));

    }

}
