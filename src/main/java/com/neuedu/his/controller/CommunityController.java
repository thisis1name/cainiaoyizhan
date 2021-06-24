package com.neuedu.his.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Community;
import com.neuedu.his.entity.Site;
import com.neuedu.his.service.ICommunityService;
import com.neuedu.his.service.ISiteService;
import com.neuedu.his.util.CommonResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * <p>
 *  小区管理
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/community")
public class CommunityController {
    @Resource
    ICommunityService communityService;

    @RequestMapping("/list")
    CommonResult page(Page page, Community community){
        return CommonResult.success(communityService.pageList(page,community));
    }

    @RequestMapping("save")
    @ResponseBody
    CommonResult save(Community community){

        return  CommonResult.success(communityService.saveOrUpdate(community));
    }
    @RequestMapping("getByName")
    CommonResult getBySiteName(String  comName){

        return CommonResult.success(communityService.getById(comName));
    }

    @RequestMapping("getById")
    CommonResult getById(String  comId){

        return CommonResult.success(communityService.getById(comId));
    }


    @RequestMapping("toedit")
    @ResponseBody
    CommonResult toedit(Community community){

        return CommonResult.success(communityService.updateById(community));
    }

    @RequestMapping("del/{comId}")
    @ResponseBody
    CommonResult delete(@PathVariable String comId){

        return  CommonResult.success(communityService.removeById(comId));
    }

    @RequestMapping("/batchdel")
    CommonResult batchdel(String[] ids){
        System.out.println(ids);
        return CommonResult.success(communityService.removeByIds(Arrays.asList(ids)));

    }

}
