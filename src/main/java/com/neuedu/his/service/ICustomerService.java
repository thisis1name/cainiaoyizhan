package com.neuedu.his.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
public interface ICustomerService extends IService<Customer> {
    Page pageList(Page page ,Customer customer);

}
