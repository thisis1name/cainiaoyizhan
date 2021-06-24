package com.neuedu.his.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.neuedu.his.entity.Community;
import com.neuedu.his.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
public interface IUserService extends IService<User> {
    Page pageList(Page page, User user);
    boolean edit(User umsUser);
    boolean logout(HttpServletRequest request);
    public String token(User user)throws JsonProcessingException;

}
