package com.neuedu.his.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Role;
import com.neuedu.his.entity.User;
import com.neuedu.his.service.IRoleMenuService;
import com.neuedu.his.service.IRoleService;
import com.neuedu.his.util.CommonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * <p>
 *  角色管理
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    IRoleService umsRoleService;

    @Resource
    IRoleMenuService roleMenuService;

    @GetMapping("/list")
    CommonResult page(Page page, Role role){
        return CommonResult.success(umsRoleService.pageList(page,role));
    }

    @GetMapping("save")
    CommonResult save(Role role){

        return  CommonResult.success(umsRoleService.saveOrUpdate(role));
    }


    @GetMapping("getById")
    CommonResult getById(Integer  roleId){

        return CommonResult.success(umsRoleService.getById(roleId));
    }


    @PostMapping("edit")
    CommonResult edit(Role umsRole){
        if(umsRoleService.edit(umsRole)){
            umsRole.setActive(1);
            return CommonResult.success("ok");
        }
        else
            return CommonResult.failed("角色名已经存在");
    }

    @PostMapping("del/{roleId}")
    CommonResult delete(@PathVariable Integer roleId){


        return  CommonResult.success(umsRoleService.removeById(roleId));
    }

    @PostMapping("/batchdel")
    CommonResult batchdel(String[] ids){
        System.out.println(ids);
        return CommonResult.success(umsRoleService.removeByIds(Arrays.asList(ids)));

    }

    @PostMapping("back")
    CommonResult back(Role umsRole){
        umsRole.setActive(1);
        return CommonResult.success(umsRoleService.updateById(umsRole));
    }


}
