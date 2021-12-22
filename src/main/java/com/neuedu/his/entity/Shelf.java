package com.neuedu.his.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 货架管理
 * </p>
 *
 * @author 刘佳
 * @since 2021-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Shelf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 货架名称
     */
    private String name;

    /**
     * 位置
     */
    private String seat;

    /**
     * 存放货物
     */
    private String goods;
    @TableLogic
    private Integer active;


}
