package com.neuedu.his.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 小区管理
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Community implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 小区编号
     */
    @TableId(value = "com_id")
    private String comId;

    /**
     * 小区名称
     */
    private String comName;

    /**
     * 小区地址
     */
    private String comAddress;

    /**
     * 对应站点
     */
    private String site;
    /**
     * 是否有效
     */
    @TableLogic
    private Integer active;


}
