package com.russionbear.notesapp.backend.userinfo.service.impl;

import com.russionbear.notesapp.backend.userinfo.entity.Collection;
import com.russionbear.notesapp.backend.userinfo.mapper.CollectionMapper;
import com.russionbear.notesapp.backend.userinfo.service.ICollectionService;
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
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, Collection> implements ICollectionService {

}
