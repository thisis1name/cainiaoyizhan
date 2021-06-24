package com.neuedu.his.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Menu;
import com.neuedu.his.entity.RoleMenu;
import com.neuedu.his.entity.UserRole;
import com.neuedu.his.mapper.MenuMapper;
import com.neuedu.his.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.his.service.IRoleMenuService;
import com.neuedu.his.service.IUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Resource
    IUserRoleService umsUserRoleService;

    @Resource
    IRoleMenuService umsRolePermissionService;

    @Override
    public Page pageList(Page page, Menu menu) {
        if (page == null ){
            page = new Page();
        }
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(menu.getMenuName())){
            wrapper.like("menu_name",menu.getMenuName());
        }
        return super.page(page,wrapper);
    }

    @Override
    public Object list(Menu permission, Page page) {
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper.eq("parentId",0);
        IPage<Menu> page1 = this.page(page,wrapper);
        List<Menu> list = page.getRecords();
        for (Menu permission1 : list) {
            getChildren(permission1);
        }
        return page1;
    }

    @Override
    public boolean edit(Menu umsPermission) {
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper.eq("menu_name",umsPermission.getMenuName());
        Menu query = this.getOne(wrapper);
        if(query == null ){
            return this.save(umsPermission);
        }
        return false;
    }

    /**
     * 参数为父节点权限对象
     * 通过父节点权限获取子节点权限
     * @param permission
     */
    private void getChildren(Menu permission){
        QueryWrapper<Menu>wrapper = new QueryWrapper<>();
        wrapper.eq("parentId",permission.getId());
        List<Menu> list = this.list(wrapper);
        for (Menu permission1 : list) {
            getChildren(permission1);

        }
        permission.setChildren(list);
    }

    @Override
    public List<Menu> userPermissionList(Integer userId) {
        //根据userId查询所有角色ums_user_role
        QueryWrapper<UserRole> umsUserQueryWrapper = new QueryWrapper<>();
        umsUserQueryWrapper.eq("userId",userId);
        UserRole umsUserRole = umsUserRoleService.getOne(umsUserQueryWrapper);
        if(umsUserRole == null || umsUserRole.getRoleId()==null){
            return null;
        }
        String[] roleIds = umsUserRole.getRoleId().toString().split(",");
        //根据角色获取roleId集合
        QueryWrapper<RoleMenu> umsRolePermissionWrapper = new QueryWrapper<>();
        umsRolePermissionWrapper.in("roleId",roleIds);
        List<RoleMenu> rolePermissionList = umsRolePermissionService.list(umsRolePermissionWrapper);
        if(rolePermissionList ==null ){
            return null;
        }

        Set permissionIdSet = new HashSet();
        for (RoleMenu umsRolePermission : rolePermissionList) {
            permissionIdSet.addAll(Arrays.asList(umsRolePermission.getMenuId().toString().split(",")));
        }
        
        //根据权限id查询权限列表
        QueryWrapper<Menu> umsPermissionQueryWrapper = new QueryWrapper<>();
        umsPermissionQueryWrapper.in("id",permissionIdSet);
        List<Menu> allPermission = this.list(umsPermissionQueryWrapper);
        //目标，将顶层菜单放入
        List<Menu> frontPermissionList = new ArrayList();
        for (Menu permission : allPermission) {
            if(permission.getParentId() == 0){
                setChildrenPermission(permission,allPermission);
                frontPermissionList.add(permission);
            }
        }
        return frontPermissionList;

    }

    private void setChildrenPermission(Menu permission, List<Menu> allPermission) {
        List<Menu> children = new ArrayList<>();
        for (Menu umsPermission : allPermission) {
            if(permission.getId() == umsPermission.getParentId()){
                setChildrenPermission(umsPermission,allPermission);
                children.add(umsPermission);
            }
        }
        permission.setChildren(children);
    }

    @Override
    public List<Menu> userPermissionListValidate(Integer userId) {
        //根据useId查询出所有角色的ums_user_role
        QueryWrapper<UserRole> umsUserQueryWrapper = new QueryWrapper<>();
        umsUserQueryWrapper.eq("userId",userId);
        UserRole umsUserRole = umsUserRoleService.getOne(umsUserQueryWrapper);
        if(umsUserRole==null || umsUserRole.getRoleId() == null){
            return null;
        }

        String[] roleIds = umsUserRole.getRoleId().toString().split(",");
        //根据角色获取权限id集合
        QueryWrapper<RoleMenu> umsRolePermissionWrapper = new QueryWrapper<>();
        umsRolePermissionWrapper.in("roleId",roleIds);
        List<RoleMenu> rolePermissionList = umsRolePermissionService.list(umsRolePermissionWrapper);
        if(rolePermissionList ==null ){
            return null;
        }

        Set permissionIdSet = new HashSet();
        for (RoleMenu umsRolePermission : rolePermissionList) {
            permissionIdSet.addAll(Arrays.asList(umsRolePermission.getMenuId().toString().split(",")));
        }

        //根据权限id查询权限列表
        QueryWrapper<Menu> umsPermissionQueryWrapper = new QueryWrapper<>();
        umsPermissionQueryWrapper.in("id",permissionIdSet);
        List<Menu> allPermission = this.list(umsPermissionQueryWrapper);
        return allPermission;
    }
}
