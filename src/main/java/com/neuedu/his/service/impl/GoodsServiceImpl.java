package com.neuedu.his.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Goods;
import com.neuedu.his.mapper.GoodsMapper;
import com.neuedu.his.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘佳
 * @since 2021-07-02
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Override
    public Page pageList(Page page, Goods goods) {
        if(page == null){
            page = new Page();
        }
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(goods.getId())){
            wrapper.like("id",goods.getId());
        }
        return super.page(page,wrapper);
    }


}
