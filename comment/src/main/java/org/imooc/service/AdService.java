package org.imooc.service;

import org.imooc.bean.Ad;

import java.util.List;

public interface AdService {
    List<Ad> getList();

    Ad getModifyAdById(String id);

    void modifyAd(Ad ad);
}
