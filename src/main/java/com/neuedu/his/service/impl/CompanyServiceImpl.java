package com.neuedu.his.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.his.entity.Community;
import com.neuedu.his.entity.Company;
import com.neuedu.his.mapper.CompanyMapper;
import com.neuedu.his.service.ICompanyService;
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
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {

    @Override
    public Page pageList(Page page, Company company) {
        if (page == null ){
            page = new Page();
        }
        QueryWrapper<Company> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(company.getCompanyId())){
            wrapper.like("company_id",company.getCompanyId());
        }
        return super.page(page,wrapper);
    }
}
