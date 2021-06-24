package com.neuedu.his.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Qrcode;
import com.neuedu.his.mapper.QrcodeMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.his.service.IQrcodeService;
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
public class QrcodeServiceImpl extends ServiceImpl<QrcodeMapper, Qrcode> implements IQrcodeService {


    @Override
    public Page pageList(Page page, Qrcode qrcode) {
        if(page == null){
            page = new Page();
        }
        QueryWrapper<Qrcode> wrapper = new QueryWrapper<>();
        if(qrcode!=null && !StringUtils.isEmpty(qrcode.getId())){
            wrapper.like("id",qrcode.getId());
        }
        return super.page(page,wrapper);
    }


}
