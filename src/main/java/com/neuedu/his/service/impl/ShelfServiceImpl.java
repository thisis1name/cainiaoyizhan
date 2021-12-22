package com.neuedu.his.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Shelf;
import com.neuedu.his.mapper.ShelfMapper;
import com.neuedu.his.service.IShelfService;
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
public class ShelfServiceImpl extends ServiceImpl<ShelfMapper, Shelf> implements IShelfService {

    @Override
    public Page pageList(Page page, Shelf shelf) {
        if (page == null){
            page = new Page();
        }
        QueryWrapper<Shelf> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(shelf.getName())){
            wrapper.like("name",shelf.getName());
        }
        return super.page(page,wrapper);
    }


}
