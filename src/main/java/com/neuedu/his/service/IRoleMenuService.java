package com.neuedu.his.service;

import com.neuedu.his.entity.Menu;
import com.neuedu.his.entity.RoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
public interface IRoleMenuService extends IService<RoleMenu> {
    List<Menu> getPermission();
    RoleMenu getByRoleId(Integer roleId);
    boolean edit(RoleMenu roleMenu);

}
