package com.neuedu.his.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 站点_小区
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SiteCommunity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 小区编号
     */
    private String comId;

    /**
     * 站点编号
     */
    private String siteId;


}
