package com.neuedu.his.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Community;
import com.neuedu.his.entity.Send;
import com.neuedu.his.mapper.SendMapper;
import com.neuedu.his.service.ISendService;
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
public class SendServiceImpl extends ServiceImpl<SendMapper, Send> implements ISendService {

    @Override
    public Page pageList(Page page, Send send) {
        if (page == null ){
            page = new Page();
        }
        QueryWrapper<Send> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(send.getId())){
            wrapper.like("id",send.getId());
        }
        return super.page(page,wrapper);
    }
}
