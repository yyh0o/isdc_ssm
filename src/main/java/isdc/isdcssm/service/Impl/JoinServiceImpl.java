package isdc.isdcssm.service.Impl;


import isdc.isdcssm.dao.ApplicationFormDAO;
import isdc.isdcssm.model.ApplicationForm;
import isdc.isdcssm.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

/**
 * Copyright (c) 2017 Peter Mao. All rights reserved.
 * Created by mao on 17-9-10.
 */
@Service("JoinService")
@Transactional
public class JoinServiceImpl implements JoinService {
    private final ApplicationFormDAO applicationFormDAO;

    @Autowired
    public JoinServiceImpl(ApplicationFormDAO applicationFormDAO) {
        this.applicationFormDAO = applicationFormDAO;
    }

    @Override
    public void submit(ApplicationForm applicationForm) {
        applicationFormDAO.updateByPrimaryKey(applicationForm);
    }

    @Override
    public Optional<ApplicationForm> queryForm(String openid) {
        return Optional.ofNullable(applicationFormDAO.queryByOpenid(openid));
    }
}
