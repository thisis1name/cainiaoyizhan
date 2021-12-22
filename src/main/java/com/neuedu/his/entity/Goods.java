package com.neuedu.his.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 货物管理
 * </p>
 *
 * @author 刘佳
 * @since 2021-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 快递单号
     */
    @TableId(value = "id")
    private String id;

    /**
     * 状态
     */
    private String status;

    /**
     * 规格
     */
    private String spec;

    /**
     * 货架
     */
    private String shelf;
    @TableLogic
    private Integer active;


}
