package com.xmg.p2p.base.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmg.p2p.base.domain.SystemDictionaryItem;
import com.xmg.p2p.base.domain.UserFile;
import com.xmg.p2p.base.domain.Userinfo;
import com.xmg.p2p.base.mapper.UserFileMapper;
import com.xmg.p2p.base.query.PageResult;
import com.xmg.p2p.base.query.UserFileQueryObject;
import com.xmg.p2p.base.service.IUserFileService;
import com.xmg.p2p.base.service.IUserinfoService;
import com.xmg.p2p.base.util.UserContext;

@Service
public class UserFileServiceImpl implements IUserFileService {

	@Autowired
	private UserFileMapper userFileMapper;
	
	@Autowired
	private IUserinfoService userinfoService;

	@Override
	public void apply(String fileName) {
		UserFile uf = new UserFile();
		uf.setApplier(UserContext.getCurrent());
		uf.setApplyTime(new Date());
		uf.setImage(fileName);
		uf.setState(UserFile.STATE_NORMAL);
		this.userFileMapper.insert(uf);
		
	}


	@Override
	public void batchUpdateFileType(Long[] ids, Long[] fileTypes) {
		for (int i = 0 ; i < ids.length; i++){
			UserFile uf = this.userFileMapper.selectByPrimaryKey(ids[i]);
			SystemDictionaryItem item = new SystemDictionaryItem();
			item.setId(fileTypes[i]);
			uf.setFileType(item);
			this.userFileMapper.updateByPrimaryKey(uf);
		}
		
	}

	
	@Override
	public List<UserFile> listFilesByHasType(Long logininfoId, boolean hasType) {
		return this.userFileMapper.listFilesByHasType(logininfoId , hasType);
	}
	
	@Override
	public List<UserFile> queryForList(UserFileQueryObject qo){
		return this.userFileMapper.query(qo);
	}


	@Override
	public PageResult query(UserFileQueryObject qo) {
		int count  = this.userFileMapper.queryForCount(qo);
		if (count > 0){
			List<UserFile> list = this.userFileMapper.query(qo);
			return new PageResult(list, count, qo.getCurrentPage(), qo.getPageSize());
		}
		return PageResult.empty(qo.getPageSize());
	}
	
	


	@Override
	public void audit(Long id, int score, String remark, int state) {
		//找到userfile,userfile状态
		UserFile uf = this.userFileMapper.selectByPrimaryKey(id);
		if (uf != null && uf.getState() == UserFile.STATE_NORMAL){
			//设置通用属性
			uf.setAuditor(UserContext.getCurrent());
			uf.setAuditTime(new Date());
			uf.setState(state);
			//如果审核通过，添加认证分数
			if (state == UserFile.STATE_AUDIT){
				uf.setScore(score);
				Userinfo userinfo = this.userinfoService.get(uf.getApplier()
						.getId());
				userinfo.setScore(userinfo.getScore() + score);
				this.userinfoService.update(userinfo);
				
			}
			this.userFileMapper.updateByPrimaryKey(uf);
		}
		
	}


	
	
}
