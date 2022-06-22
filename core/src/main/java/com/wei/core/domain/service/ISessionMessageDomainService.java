package com.wei.core.domain.service;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.wei.core.domain.bo.SessionMessage;
import com.wei.core.domain.entity.SessionMessageDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wei.core.domain.query.SessionMessageQuery;

import java.util.List;

/**
 * <p>
 * 会话消息表 服务类
 * </p>
 *
 * @author blingweiwei
 * @since 2022-06-10
 */
public interface ISessionMessageDomainService extends IService<SessionMessageDO> {

    SessionMessage query(SessionMessageQuery sessionMessageQuery);

    List<SessionMessage> list(SessionMessageQuery sessionMessageQuery);

}
