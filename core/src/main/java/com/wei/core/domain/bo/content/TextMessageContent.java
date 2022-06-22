package com.wei.core.domain.bo.content;

import com.wei.core.domain.bo.AbstractMessageContent;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.annotation.PostConstruct;

@EqualsAndHashCode(callSuper = true)
@Data
public class TextMessageContent extends AbstractMessageContent {


    @PostConstruct
    public void init() {
        this.desc = "text";
    }

    private String content;


}
