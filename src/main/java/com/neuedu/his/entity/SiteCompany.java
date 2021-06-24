package com.neuedu.his.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 站点_公司
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SiteCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 站点编号
     */
    private String siteId;

    /**
     * 快递公司编号
     */
    private String companyId;


}
