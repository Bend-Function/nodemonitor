package com.funcs.nodemonitor.service.impl;

import com.funcs.nodemonitor.entity.Info;
import com.funcs.nodemonitor.mapper.InfoMapper;
import com.funcs.nodemonitor.service.InfoService;
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
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements InfoService {

}
