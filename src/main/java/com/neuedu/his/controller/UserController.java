package com.neuedu.his.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.neuedu.his.entity.Site;
import com.neuedu.his.entity.User;
import com.neuedu.his.service.IUserService;
import com.neuedu.his.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Locale;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    IUserService umsUserService;

    @RequestMapping("/list")
    CommonResult page(Page page, User user){
        return CommonResult.success(umsUserService.pageList(page,user));
    }

    @PostMapping("save")
    CommonResult save(User umsUser){

        return  CommonResult.success(umsUserService.saveOrUpdate(umsUser));
    }


    @GetMapping("getById")
    CommonResult getById(Integer  userId){

        return CommonResult.success(umsUserService.getById(userId));
    }

    @RequestMapping("getUsername")
    CommonResult getUsername(HttpServletRequest request){
        String method = request.getMethod();
        if(method.toLowerCase().equals("option")){
            CommonResult.success(null);
        }
        String token = request.getHeader("token");
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("loginUser")).build();
        DecodedJWT jwt =verifier.verify(token);
        String username = jwt.getClaim("username").asString();
        return CommonResult.success(username);
    }

    @PostMapping("edit")
    CommonResult toedit(User umsUser){
        if(umsUserService.edit(umsUser)){
            return CommonResult.success("ok");
        }else {
            return CommonResult.failed("用户名已经存在");
        }

    }

    @PostMapping("del/{userId}")
    CommonResult delete(@PathVariable Integer  userId){

        return  CommonResult.success(umsUserService.removeById(userId));
    }

    @RequestMapping("/batchdel")
    CommonResult batchdel(String[] ids){
        System.out.println(ids);
        return CommonResult.success(umsUserService.removeByIds(Arrays.asList(ids)));

    }

    @RequestMapping("/token")
    CommonResult token(User user) {
        if (user != null) {
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("username", user.getUsername());
            User user1 = umsUserService.getOne(wrapper);
            if (user1 != null) {
                if (user.getPassword().equals(user1.getPassword())) {
                    JWTCreator.Builder builder = JWT.create();
                    String token = builder.withClaim("id", user1.getUserId())
                            .withClaim("username", user1.getUsername())
                            .sign(Algorithm.HMAC256("loginUser"));
                    return CommonResult.success(token);
                }
            }

        }
        return CommonResult.failed("用户名或密码错误");
    }

    @PostMapping("logout")
    CommonResult logout(HttpServletRequest request)throws JsonProcessingException{
        return CommonResult.success(umsUserService.logout(request));
    }

}
