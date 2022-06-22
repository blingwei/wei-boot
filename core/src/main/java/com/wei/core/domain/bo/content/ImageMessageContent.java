package com.wei.core.domain.bo.content;

import com.wei.core.domain.bo.AbstractMessageContent;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.annotation.PostConstruct;

@EqualsAndHashCode(callSuper = true)
@Data
public class ImageMessageContent extends AbstractMessageContent {


    private String url;

    private Long width;

    private Long height;

    @PostConstruct
    public void init() {
        this.desc = "image";
    }


}
