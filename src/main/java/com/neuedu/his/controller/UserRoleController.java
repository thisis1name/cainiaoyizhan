package com.neuedu.his.controller;


import com.neuedu.his.entity.UserRole;
import com.neuedu.his.service.IUserRoleService;
import com.neuedu.his.util.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  用户_角色
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/userRole")
public class UserRoleController {
    @Resource
    IUserRoleService umsUserRoleService;
    @PostMapping("/save")
    CommonResult save(UserRole umsUserRole) {
        return CommonResult.success(umsUserRoleService.saveOrUpdate(umsUserRole));
    }
    @GetMapping("/getByUserId")
    CommonResult getByuserId(Integer userId) {
        return CommonResult.success(umsUserRoleService.getByUserId(userId));
    }

}
