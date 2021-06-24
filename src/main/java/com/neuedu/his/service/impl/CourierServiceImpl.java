package com.neuedu.his.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Community;
import com.neuedu.his.entity.Courier;
import com.neuedu.his.mapper.CourierMapper;
import com.neuedu.his.service.ICourierService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class CourierServiceImpl extends ServiceImpl<CourierMapper, Courier> implements ICourierService {

    @Override
    public Page pageList(Page page, Courier courier) {
        if (page == null ){
            page = new Page();
        }
        QueryWrapper<Courier> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(courier.getCourierName())){
            wrapper.like("courier_name",courier.getCourierName());
        }
        wrapper.like("active",1);
        return super.page(page,wrapper);

    }

    @Override
    public boolean batchdel(String[] ids) {
        List<String> list = new ArrayList<>(ids.length);
        Collections.addAll(list,ids);
        Courier courier = new Courier();

        UpdateWrapper<Courier> wrapper = new UpdateWrapper<>();
        wrapper.in("courier_id",list);
        return this.removeByIds(list);
    }
}
