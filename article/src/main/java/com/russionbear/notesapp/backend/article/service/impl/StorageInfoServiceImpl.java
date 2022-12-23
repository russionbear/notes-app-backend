package com.russionbear.notesapp.backend.article.service.impl;

import com.russionbear.notesapp.backend.article.entity.StorageInfo;
import com.russionbear.notesapp.backend.article.mapper.StorageInfoMapper;
import com.russionbear.notesapp.backend.article.service.IStorageInfoService;
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
public class StorageInfoServiceImpl extends ServiceImpl<StorageInfoMapper, StorageInfo> implements IStorageInfoService {

}
