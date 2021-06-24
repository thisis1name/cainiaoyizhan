package com.neuedu.his.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Community;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.his.entity.Site;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
public interface ICommunityService extends IService<Community> {

    Page pageList(Page page, Community community);

}
