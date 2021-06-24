package com.neuedu.his.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Menu;
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
public interface IMenuService extends IService<Menu> {

    Page pageList(Page page,Menu menu);
    Object list(Menu permission,Page page);
    boolean edit(Menu umsPermission);
    List<Menu> userPermissionList(Integer userId);
    List<Menu> userPermissionListValidate(Integer userId);

}
