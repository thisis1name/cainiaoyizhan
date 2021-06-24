package com.neuedu.his.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 客户管理
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户姓名
     */
    @TableId(value = "customer_name")
    private String customerName;

    /**
     * 手机号
     */
    private String customerPhone;

    /**
     * 是否有效
     */
    @TableLogic
    private Integer active;


}
