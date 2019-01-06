package org.imooc.dao;

import org.apache.ibatis.annotations.Param;
import org.imooc.bean.Ad;

import java.util.List;


public interface AdDao {
    List<Ad> selectAdList();

    Ad selectOneById(@Param("id") String id);
}