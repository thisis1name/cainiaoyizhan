package com.neuedu.his.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.neuedu.his.entity.Community;
import com.neuedu.his.entity.User;
import com.neuedu.his.mapper.UserMapper;
import com.neuedu.his.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.his.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Override
    public Page pageList(Page page, User user) {
        if (page == null ){
            page = new Page();
        }
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(user.getUsername())){
            wrapper.like("username",user.getUsername());
        }
        return super.page(page,wrapper);
    }

    @Override
    public boolean edit(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",user.getUsername());
        User query = this.getOne(wrapper);
        if(query == null)
            return this.save(user);
        return false;
    }

    @Override
    public boolean logout(HttpServletRequest request) {
        return false;
    }

    @Override
    public String token(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //根据用户名查询用户对象
        wrapper.eq("username",user.getUsername());
        User queryUser = this.getOne(wrapper);
        if (queryUser!=null){
            //如果用户名存在则验证密码
            //如果密码一致则认为登录成功
            if((user.getPassword().equals(queryUser.getPassword()))){
                //将用户信息生成token数据返回给前端

                String token =JWTUtil.create(queryUser);
                return token;
            }

        }
        return null;
    }


}
