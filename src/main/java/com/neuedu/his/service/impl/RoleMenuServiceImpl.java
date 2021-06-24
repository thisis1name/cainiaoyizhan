package com.neuedu.his.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neuedu.his.entity.Menu;
import com.neuedu.his.entity.Role;
import com.neuedu.his.entity.RoleMenu;
import com.neuedu.his.mapper.RoleMenuMapper;
import com.neuedu.his.service.IMenuService;
import com.neuedu.his.service.IRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

    @Resource
    IMenuService umsPermissionService;

    @Override
    public List<Menu> getPermission() {
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper.eq("parentId",0);
        wrapper.eq("active",1);
        List<Menu> list = umsPermissionService.list(wrapper);
        for(Menu permission : list) {
            getChildren(permission);
        }
        return list;
    }

    @Override
    public RoleMenu getByRoleId(Integer roleId) {
        QueryWrapper<RoleMenu> wrapper = new QueryWrapper<>();
        wrapper.eq("roleId",roleId);
        return this.getOne(wrapper);
    }

    /**
     * 参数为父节点权限对象
     * 通过父节点权限获取子节点权限
     * @param umsPermission
     */
    private void getChildren(Menu umsPermission) {
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper.eq("parentId",umsPermission.getId());
        wrapper.eq("active",1);
        List<Menu> list = umsPermissionService.list(wrapper);
        for(Menu permission : list) {
            getChildren(permission);
        }
        umsPermission.setChildren(list);
    }
    Role role;

    @Override
    public boolean edit(RoleMenu roleMenu) {
        QueryWrapper<RoleMenu> wrapper = new QueryWrapper<>();
        wrapper.eq("roleId",role.getRoleId());
        RoleMenu query = this.getOne(wrapper);
        if(query == null )
            return this.save(roleMenu);
        return false;
    }

}
