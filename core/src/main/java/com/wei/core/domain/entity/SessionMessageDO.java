package com.wei.core.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import com.wei.core.domain.common.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 会话消息表
 * </p>
 *
 * @author blingweiwei
 * @since 2022-06-10
 */
@EqualsAndHashCode(callSuper = true)
@TableName("session_message")
@ApiModel(value = "SessionMessage对象", description = "会话消息表")
@Data
public class SessionMessageDO extends BaseDO {


    @ApiModelProperty("消息id")
    private String messageId;

    @ApiModelProperty("会话id")
    private Long sessionId;

    @ApiModelProperty("消息发送者id")
    private Long formUserId;

    @ApiModelProperty("消息接收者id")
    private Long toUserId;

    @ApiModelProperty("消息类型 1.文本 2.图片 3.录音")
    private Integer messageType;

    @ApiModelProperty("消息内容")
    private String messageContent;

    @ApiModelProperty("扩展字段")
    private String feature;

}
