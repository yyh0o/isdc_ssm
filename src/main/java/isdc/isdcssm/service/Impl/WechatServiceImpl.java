package isdc.isdcssm.service.Impl;

import isdc.isdcssm.dao.ApplicationFormDAO;
import isdc.isdcssm.model.ApplicationForm;
import isdc.isdcssm.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weixin.popular.util.SignatureUtil;



/**
 * Copyright (c) 2017 Peter Mao. All rights reserved.
 * Created by mao on 17-9-10.
 */
@Service("WechatService")
@Transactional
public class WechatServiceImpl implements WechatService {

    private final String token;
    private final ApplicationFormDAO applicationFormDAO;
    @Autowired
    public WechatServiceImpl(@Value("${weixin.messageToken:token}") String token, ApplicationFormDAO applicationFormDAO) {
        this.token = token;
        this.applicationFormDAO = applicationFormDAO;
    }

    @Override
    public boolean checkSignature(String timestamp, String nonce, String signature) {
        return signature.equals(SignatureUtil.generateEventMessageSignature(token, timestamp, nonce));
    }

    @Override
    public void saveOpenid(String openid) {
        if (applicationFormDAO.queryByOpenid(openid)==null) {
            ApplicationForm applicationForm = new ApplicationForm();
            applicationForm.setOpenid(openid);
            applicationForm.setBlock(false);
            applicationForm.setPass(false);
            applicationFormDAO.insert(applicationForm);
        }
    }
}
