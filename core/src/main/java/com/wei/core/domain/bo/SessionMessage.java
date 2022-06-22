package com.wei.core.domain.bo;

import com.wei.core.domain.enums.MessageTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SessionMessage {

    private Long id;

    private String messageId;


    private Long sessionId;


    private Long formUserId;


    private Long toUserId;


    private MessageTypeEnum messageType;


    private AbstractMessageContent messageContent;

}
