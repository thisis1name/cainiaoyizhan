package com.neuedu.his.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Menu;
import com.neuedu.his.entity.Site;
import com.neuedu.his.service.IMenuService;
import com.neuedu.his.util.CommonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Resource
    IMenuService menuService;

    @GetMapping("/list")
    CommonResult page(Page page, Menu menu){

        return CommonResult.success(menuService.pageList(page,menu));
    }

    @PostMapping("save")
    CommonResult save(Menu menu){

        return  CommonResult.success(menuService.saveOrUpdate(menu));
    }


    @GetMapping("getById")
    CommonResult getById(Integer id){

        return CommonResult.success(menuService.getById(id));
    }


    @PostMapping("edit")
    CommonResult edit(Menu umsPermission){
        if (menuService.edit(umsPermission)){
            return CommonResult.success("ok");
        }else {
            return CommonResult.failed("权限名已经存在");
        }

    }

    @PostMapping("del/{id}")
    CommonResult delete(@PathVariable Integer id) {

        return CommonResult.success(menuService.removeById(id));
    }

    @PostMapping("/back")
    CommonResult back(Menu umsPermission){
        umsPermission.setActive(1);
        return CommonResult.success(menuService.updateById(umsPermission));
    }


    @RequestMapping("/userPermissionList")
    CommonResult userPermissionList(HttpServletRequest request){
        String method = request.getMethod();
        if(method.toLowerCase().equals("option")){
            CommonResult.success(null);
        }
        String token = request.getHeader("token");
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("loginUser")).build();
        DecodedJWT jwt = verifier.verify(token);
        Integer userId = jwt.getClaim("id").asInt();
        return CommonResult.success(menuService.userPermissionList(userId));
    }

}
