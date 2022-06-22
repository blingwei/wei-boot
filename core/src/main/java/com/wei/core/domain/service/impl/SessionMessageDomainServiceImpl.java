package com.wei.core.domain.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wei.core.domain.bo.AbstractMessageContent;
import com.wei.core.domain.bo.SessionMessage;
import com.wei.core.domain.entity.SessionMessageDO;
import com.wei.core.domain.enums.MessageTypeEnum;
import com.wei.core.domain.mapper.SessionMessageMapper;
import com.wei.core.domain.query.SessionMessageQuery;
import com.wei.core.domain.service.ISessionMessageDomainService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 会话消息表 服务实现类
 * </p>
 *
 * @author blingweiwei
 * @since 2022-06-10
 */
@Service
public class SessionMessageDomainServiceImpl extends ServiceImpl<SessionMessageMapper, SessionMessageDO> implements ISessionMessageDomainService {


    @Override
    public SessionMessage query(SessionMessageQuery sessionMessageQuery) {
        QueryWrapper<SessionMessageDO> queryWrapper = covertQuery(sessionMessageQuery);
        SessionMessageDO sessionMessageDO = this.getOne(queryWrapper);
        return do2bo(sessionMessageDO);
    }


    @Override
    public List<SessionMessage> list(SessionMessageQuery sessionMessageQuery) {
        QueryWrapper<SessionMessageDO> queryWrapper = covertQuery(sessionMessageQuery);
        List<SessionMessageDO> sessionMessageDOList = this.list(queryWrapper);
        if (CollectionUtils.isEmpty(sessionMessageDOList)) {
            return new ArrayList<>();
        }
        return sessionMessageDOList.stream().map(this::do2bo).collect(Collectors.toList());
    }


    private SessionMessage do2bo(SessionMessageDO sessionMessageDO) {
        if (sessionMessageDO == null) {
            return null;
        }
        SessionMessage sessionMessage = BeanUtil.toBeanIgnoreError(sessionMessageDO, SessionMessage.class);
        sessionMessage.setMessageType(MessageTypeEnum.getEnumType(sessionMessageDO.getMessageType()));
        sessionMessage.setMessageContent(JSONUtil.toBean(sessionMessageDO.getMessageContent(), AbstractMessageContent.class, true));
        return sessionMessage;
    }

    private QueryWrapper<SessionMessageDO> covertQuery(SessionMessageQuery sessionMessageQuery) {
        QueryWrapper<SessionMessageDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(sessionMessageQuery.getSessionId() != null, SessionMessageDO::getSessionId, sessionMessageQuery.getSessionId())
                .eq(sessionMessageQuery.getId() != null, SessionMessageDO::getId, sessionMessageQuery.getId());
        return queryWrapper;


    }
}
