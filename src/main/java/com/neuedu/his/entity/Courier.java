package com.neuedu.his.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 快递员
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Courier implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 快递员编号
     */
    @TableId(value = "courier_id")
    private String courierId;


    /**
     * 快递员姓名
     */
    private String courierName;

    /**
     * 性别
     */
    private String gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 归属公司
     */
    private String company;

    /**
     * 是否有效
     */
    @TableLogic
    private Integer active;



}
