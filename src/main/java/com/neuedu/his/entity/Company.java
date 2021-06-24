package com.neuedu.his.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 公司管理
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 快递公司编号
     */
    @TableId(value = "company_id")
    private String companyId;

    /**
     * 快递公司名称
     */
    private String companyName;

    /**
     * 是否有效
     */
    @TableLogic
    private Integer active;


}
