package com.neuedu.his.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Customer;
import com.neuedu.his.mapper.CustomerMapper;
import com.neuedu.his.service.ICustomerService;
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
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Override
    public Page pageList(Page page, Customer customer) {
        if (page == null){
            page = new Page();
        }
        QueryWrapper<Customer> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(customer.getCustomerName())){
            wrapper.like("customer_name",customer.getCustomerName());
        }
        return super.page(page,wrapper);
    }
}
