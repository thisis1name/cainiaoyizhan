package com.neuedu.his.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Community;
import com.neuedu.his.entity.Site;
import com.neuedu.his.mapper.CommunityMapper;
import com.neuedu.his.service.ICommunityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
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
public class CommunityServiceImpl extends ServiceImpl<CommunityMapper, Community> implements ICommunityService {


    @Override
    public Page pageList(Page page, Community community) {
        if (page == null ){
            page = new Page();
        }
        QueryWrapper<Community> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(community.getComName())){
            wrapper.like("com_name",community.getComName());
        }
        return super.page(page,wrapper);
    }
}
