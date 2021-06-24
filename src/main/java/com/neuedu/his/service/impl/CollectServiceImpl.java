package com.neuedu.his.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Collect;
import com.neuedu.his.mapper.CollectMapper;
import com.neuedu.his.service.ICollectService;
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
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements ICollectService {

    @Override
    public Page pageList(Page page, Collect collect) {
        if (page == null ){
            page = new Page();
        }
        QueryWrapper<Collect> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(collect.getId())){
            wrapper.like("id",collect.getId());
        }
        return super.page(page,wrapper);
    }
}
