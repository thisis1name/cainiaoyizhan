package com.neuedu.his.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Community;
import com.neuedu.his.entity.Role;
import com.neuedu.his.mapper.RoleMapper;
import com.neuedu.his.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public Page pageList(Page page, Role role) {
        if (page == null ){
            page = new Page();
        }
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(role.getRoleName())){
            wrapper.like("role_name",role.getRoleName());
        }
        return super.page(page,wrapper);    }

    @Override
    public boolean edit(Role umsRole) {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.eq("role_name",umsRole.getRoleName());
        Role query = this.getOne(wrapper);
        if(query == null )
            return this.save(umsRole);
        return false;
    }
}
