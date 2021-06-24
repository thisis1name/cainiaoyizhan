package com.neuedu.his.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 站点管理
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Site implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 站点编号
     */
    @TableId(value = "site_id")
    private String siteId;

    /**
     * 站点名称
     */
    private String siteName;

    /**
     * 负责人姓名
     */
    private String principalName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 类别
     */
    private String sort;

    /**
     * 位置
     */
    private String siteAddress;

    /**
     * 是否有效
     */
    @TableLogic
    private Integer active;


}
