package com.wei.core.domain.enums;




import lombok.Getter;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2022/1/21  上午11:24
 * @Version 1.0
 */
@Getter
public enum MessageTypeEnum {

    UN_KNOW(0, "未知消息"),
    TEXT(1, "文本消息"),
    IMAGE(2, "图片消息"),
    AUDIO(3, "语音消息"),
    ;


    MessageTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    private Integer type;
    private String desc;

    public static MessageTypeEnum getEnumType(Integer type) {
        return Arrays.asList(MessageTypeEnum.values()).stream()
                .filter(e -> e.getType().equals(type))
                .findFirst().orElse(MessageTypeEnum.UN_KNOW);
    }
}
