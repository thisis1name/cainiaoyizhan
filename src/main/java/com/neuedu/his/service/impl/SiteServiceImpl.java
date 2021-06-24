package com.neuedu.his.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Site;
import com.neuedu.his.mapper.SiteMapper;
import com.neuedu.his.service.ISiteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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
public class SiteServiceImpl extends ServiceImpl<SiteMapper, Site> implements ISiteService {


    @Override
    public Page pageList(Page page, Site site) {
        if(page == null){
            page = new Page();
        }
        QueryWrapper<Site> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(site.getSiteId())){
            wrapper.like("site_id",site.getSiteId());
        }
        return super.page(page,wrapper);
    }




}
