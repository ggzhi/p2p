package com.xmg.p2p.base.domain;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import lombok.Getter;
import lombok.Setter;

/**
 * 风控材料
 * 
 * @author Administrator
 * 
 */
@Setter
@Getter
public class UserFile extends BaseAuditDomain {

	private String image;// 风控材料图片;
	private SystemDictionaryItem fileType;// 风控材料分类
	private int score;// 风控材料评分
	
	public String getJsonString() {
		Map<String, Object> json = new HashMap<>();
		json.put("id", id);
		json.put("applier", this.applier.getUsername());
		json.put("fileType", this.fileType.getTitle());
		json.put("image", image);
		return JSONObject.toJSONString(json);
	}
}
