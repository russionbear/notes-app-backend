package com.russionbear.notesapp.backend.userinfo.service.impl;

import com.russionbear.notesapp.backend.userinfo.entity.TokenInfo;
import com.russionbear.notesapp.backend.userinfo.mapper.TokenInfoMapper;
import com.russionbear.notesapp.backend.userinfo.service.ITokenInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author russionbear
 * @since 2022-12-17
 */
@Service
public class TokenInfoServiceImpl extends ServiceImpl<TokenInfoMapper, TokenInfo> implements ITokenInfoService {

}
