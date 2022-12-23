package com.russionbear.notesapp.backend.userinfo.service.impl;

import com.russionbear.notesapp.backend.userinfo.entity.UserInfo;
import com.russionbear.notesapp.backend.userinfo.mapper.UserInfoMapper;
import com.russionbear.notesapp.backend.userinfo.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author russionbear
 * @since 2022-12-16
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
