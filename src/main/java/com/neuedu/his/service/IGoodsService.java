package com.neuedu.his.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  货物管理
 * </p>
 *
 * @author 刘佳
 * @since 2021-07-02
 */
public interface IGoodsService extends IService<Goods> {
    Page pageList(Page page,Goods goods);
//    boolean batchdel(Integer[] ids);

}
