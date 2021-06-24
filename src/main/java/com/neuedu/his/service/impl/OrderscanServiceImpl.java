package com.neuedu.his.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Orderscan;
import com.neuedu.his.mapper.OrderscanMapper;
import com.neuedu.his.service.IOrderscanService;
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
public class OrderscanServiceImpl extends ServiceImpl<OrderscanMapper, Orderscan> implements IOrderscanService {

    @Override
    public Page pageList(Page page, Orderscan orderscan) {
        if (page == null ){
            page = new Page();
        }
        QueryWrapper<Orderscan> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(orderscan.getId())){
            wrapper.like("id",orderscan.getId());
        }
        return super.page(page,wrapper);    }
}
