package com.neuedu.his.controller;


import com.neuedu.his.entity.RoleMenu;
import com.neuedu.his.service.IRoleMenuService;
import com.neuedu.his.service.IRoleService;
import com.neuedu.his.util.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  菜单管理
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/roleMenu")
public class RoleMenuController {
    @Resource
    IRoleMenuService umsRolePermissionService;

    @GetMapping("get-permiss")
    CommonResult getPermiss(){
        return CommonResult.success(umsRolePermissionService.getPermission());
    }

    @PostMapping("edit")
    CommonResult edit(RoleMenu umsRolePermission){

        if (umsRolePermissionService.edit(umsRolePermission)){
            return CommonResult.success("ok");
        }else{
            return CommonResult.failed("角色名已经存在");
        }

    }

    @PostMapping("save")
    CommonResult save(RoleMenu umsRolePermission){
        return CommonResult.success(umsRolePermissionService.saveOrUpdate(umsRolePermission));
    }

    @GetMapping("getByRoleId")
    CommonResult getByRoleId(Integer roleId){
        return CommonResult.success(umsRolePermissionService.getByRoleId(roleId));
    }

}
