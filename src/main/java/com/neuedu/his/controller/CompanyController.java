package com.neuedu.his.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Company;
import com.neuedu.his.entity.Courier;
import com.neuedu.his.entity.Site;
import com.neuedu.his.service.ICompanyService;
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
 *  公司表
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Resource
    ICompanyService companyService;

    @RequestMapping("/plist")
    @ResponseBody
    CommonResult findAllCompany(){
        List<Company> list = companyService.list(null);
        return CommonResult.success(list);
    }

    @RequestMapping("/list")
    CommonResult page(Page page, Company company){
        return CommonResult.success(companyService.pageList(page,company));
    }

    @RequestMapping("save")
    @ResponseBody
    CommonResult save(Company company){

        return  CommonResult.success(companyService.saveOrUpdate(company));
    }


    @RequestMapping("getById")
    CommonResult getById(String  companyId){

        return CommonResult.success(companyService.getById(companyId));
    }


    @RequestMapping("edit")
    @ResponseBody
    CommonResult edit(Company company){

        return CommonResult.success(companyService.updateById(company));
    }

    @RequestMapping("del/{id}")
    @ResponseBody
    CommonResult delete(@PathVariable String id){

        return  CommonResult.success(companyService.removeById(id));
    }

    @RequestMapping("/batchdel")
    CommonResult batchdel(String[] ids){

        return CommonResult.success(companyService.removeByIds(Arrays.asList(ids)));
    }


}
