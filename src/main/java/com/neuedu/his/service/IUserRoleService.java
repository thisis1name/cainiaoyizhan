package com.neuedu.his.service;

import com.neuedu.his.entity.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
public interface IUserRoleService extends IService<UserRole> {

    UserRole getByUserId(Integer userId);
}
