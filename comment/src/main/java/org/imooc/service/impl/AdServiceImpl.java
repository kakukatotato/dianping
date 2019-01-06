package org.imooc.service.impl;

import org.imooc.bean.Ad;
import org.imooc.dao.AdDao;
import org.imooc.dto.AdDto;
import org.imooc.service.AdService;
import org.imooc.util.FileUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private  AdDao adDao;

    @Override
    public List<Ad> getList() {
        List<Ad> adList = adDao.selectAdList();
        return adList;
    }

    @Override
    public Ad getModifyAdById(String id) {
        return adDao.selectOneById(id);
    }

    @Override
    public void modifyAd(Ad ad) {
        adDao.updateAd();
    }


}
