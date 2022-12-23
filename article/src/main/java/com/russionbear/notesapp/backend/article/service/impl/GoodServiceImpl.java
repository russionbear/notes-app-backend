package com.russionbear.notesapp.backend.article.service.impl;

import com.russionbear.notesapp.backend.article.entity.Good;
import com.russionbear.notesapp.backend.article.mapper.GoodMapper;
import com.russionbear.notesapp.backend.article.service.IGoodService;
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
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Good> implements IGoodService {

}
