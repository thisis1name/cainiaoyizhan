package com.neuedu.his.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 派件管理
 * </p>
 *
 * @author 刘佳
 * @since 2021-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Send implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 快件单号
     */
    @TableId(value = "id")
    private String id;

    /**
     * 发件人
     */
    private String addresser;

    /**
     * 发件地址
     */
    private String addresserAddress;

    /**
     * 发件人手机号
     */
    private String addresserPhone;

    /**
     * 收件人
     */
    private String addressee;

    /**
     * 收件地址
     */
    private String addresseeAddress;

    /**
     * 收件人手机号
     */
    private String addresseePhone;

    /**
     * 取件码
     */
    private String code;

    /**
     * 状态
     */
    private String status;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 是否有效
     */
    @TableLogic
    private Integer active;


}
