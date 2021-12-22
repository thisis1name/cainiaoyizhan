package com.neuedu.his.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Shelf;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  货架管理
 * </p>
 *
 * @author 刘佳
 * @since 2021-07-02
 */
public interface IShelfService extends IService<Shelf> {
    Page pageList(Page page,Shelf shelf);
//    boolean batchdel(Integer[] ids);

}
