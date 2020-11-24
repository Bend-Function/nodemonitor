package com.funcs.nodemonitor.service.impl;

import com.funcs.nodemonitor.entity.Server;
import com.funcs.nodemonitor.mapper.ServerMapper;
import com.funcs.nodemonitor.service.ServerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Function
 * @since 2020-11-24
 */
@Service
public class ServerServiceImpl extends ServiceImpl<ServerMapper, Server> implements ServerService {

}
