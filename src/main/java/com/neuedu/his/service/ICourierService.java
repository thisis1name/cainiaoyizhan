package com.neuedu.his.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Courier;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
public interface ICourierService extends IService<Courier> {
    Page pageList(Page page ,Courier courier);
    boolean batchdel(String[] ids);

}
