package com.xmg.p2p.base.service;

import java.util.List;

import com.xmg.p2p.base.domain.UserFile;
import com.xmg.p2p.base.query.PageResult;
import com.xmg.p2p.base.query.UserFileQueryObject;

/**
 * 风控资料服务
 * @author 14847
 *
 */
public interface IUserFileService {

	
	/**
	 * 上传一个风控资料对象
	 */
	
	void apply(String fileName);
	
	
	/**
	 * 列出一个用户风控材料对象
	 * hasType 如果为true,选择有类型的，如果为false，选择没有类型的
	 * @param id
	 * @return
	 */
	List<UserFile> listFilesByHasType(Long logininfoId,boolean hasType);

	/**
	 * 批量的处理用户风控资料类型的选择
	 * @param id
	 * @param fileType
	 */
	void batchUpdateFileType(Long[] ids, Long[] fileTypes);
	
	PageResult query(UserFileQueryObject qo);

	List<UserFile> queryForList(UserFileQueryObject qo);
	/**
	 * 审核
	 * @param id
	 * @param state
	 * @param remark
	 * @param state2
	 */
	void audit(Long id, int state, String remark, int state2);
}
