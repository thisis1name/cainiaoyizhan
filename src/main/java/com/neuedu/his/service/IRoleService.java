package com.neuedu.his.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
public interface IRoleService extends IService<Role> {

    Page pageList(Page page,Role role);

    boolean edit(Role umsRole);
}
