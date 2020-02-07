package com.xmg.p2p.base.mapper;

import java.util.List;
import java.util.Map;

import com.xmg.p2p.base.domain.Userinfo;

public interface UserinfoMapper {

    int insert(Userinfo record);

    Userinfo selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Userinfo record);

	List<Map<String, Object>> autocomplate(String keyword);
}