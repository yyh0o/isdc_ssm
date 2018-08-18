package isdc.isdcssm.service.Impl;



import isdc.isdcssm.dao.BannerDAO;
import isdc.isdcssm.model.Banner;
import isdc.isdcssm.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Copyright (c) 2017 Peter Mao. All rights reserved.
 * Created by mao on 17-7-24.
 */
@Service("BannerService")
@Transactional
public class BannerServiceImpl implements BannerService {

    private final BannerDAO bannerDAO;

    @Autowired
    public BannerServiceImpl(BannerDAO bannerDAO) {
        this.bannerDAO = bannerDAO;
    }

    @Override
    public List<Banner> findAll() {
        return bannerDAO.selectAll();
    }

    @Override
    public void save(Banner banner) {
        bannerDAO.insert(banner);
    }

    @Override
    public void update(Banner banner) {
        bannerDAO.updateByPrimaryKey(banner);
    }

    @Override
    public void delete(Banner banner) {
        bannerDAO.delete(banner);
    }
}
