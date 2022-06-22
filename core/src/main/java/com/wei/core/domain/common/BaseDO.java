package com.wei.core.domain.common;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("版本号")
    private Integer version;

    @ApiModelProperty("环境标识,test 测试环境，dev 开发环境，pre 预发环境，prod 生产环境")
    @TableField(fill = FieldFill.INSERT)
    private String ownSign;

    @ApiModelProperty("db备注，数据订正时说明原因")
    private String dbRemark;

    @ApiModelProperty("是否删除 0-未删除 1-已删除")
    private Integer deleted;
}
