package com.russionbear.notesapp.backend.article.service.impl;

import com.russionbear.notesapp.backend.article.entity.NoteInfo;
import com.russionbear.notesapp.backend.article.mapper.NoteInfoMapper;
import com.russionbear.notesapp.backend.article.service.INoteInfoService;
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
public class NoteInfoServiceImpl extends ServiceImpl<NoteInfoMapper, NoteInfo> implements INoteInfoService {

}
