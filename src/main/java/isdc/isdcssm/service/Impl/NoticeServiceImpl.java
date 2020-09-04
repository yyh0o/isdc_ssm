package isdc.isdcssm.service.Impl;


import isdc.isdcssm.dao.NoticeDAO;
import isdc.isdcssm.model.Notice;
import isdc.isdcssm.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Copyright (c) 2017 Peter Mao. All rights reserved.
 * Created by mao on 17-7-21.
 */
@Service("NoticeService")
@Transactional
public class NoticeServiceImpl implements NoticeService {

    private final NoticeDAO noticeDAO;


    @Autowired
    public NoticeServiceImpl(NoticeDAO noticeDAO) {
        this.noticeDAO = noticeDAO;
    }

    @Override
    public List<Notice> listAll() {
        return noticeDAO.findAll();
    }

}
