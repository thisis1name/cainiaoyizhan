package com.neuedu.his.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 公司_快递员
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CompanyCourier implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 快递公司编号
     */
    private String companyId;

    /**
     * 快递员编号
     */
    private String courierId;


}
