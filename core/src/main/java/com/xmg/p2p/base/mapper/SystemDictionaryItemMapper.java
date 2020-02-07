package com.xmg.p2p.base.mapper;

import java.util.List;

import com.xmg.p2p.base.domain.SystemDictionaryItem;
import com.xmg.p2p.base.query.SystemDictionaryQueryObject;

public interface SystemDictionaryItemMapper {
    
	 	int insert(SystemDictionaryItem record);

	    SystemDictionaryItem selectByPrimaryKey(Long id);

	    int updateByPrimaryKey(SystemDictionaryItem record);
	    
	    /**
	     * 分页相关的查询
	     */
	    int queryForCount(SystemDictionaryQueryObject qo);
	    List<SystemDictionaryItem> query(SystemDictionaryQueryObject qo);
	    
	    /**
	     * 根据数据字典分类sn查询明细
	     * @param sn
	     * @return
	     */
	    List<SystemDictionaryItem> listByParentSn(String sn);
	    
}