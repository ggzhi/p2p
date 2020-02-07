package com.xmg.p2p.base.domain;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import lombok.Getter;
import lombok.Setter;

/**
 * 数据字典明细
 * @author 14847
 *
 */
@Setter
@Getter
public class SystemDictionaryItem extends BaseDomain {
	
	private Long parentId;
	private String title;
	private int sequence;
	
	/**
	 * 返回当前的json字符串
	 * @return
	 */
	public String getJsonString(){
		Map<String,Object> json=new HashMap<>();
		json.put("id",id);
		json.put("title", title);
		json.put("sequence", sequence);
		json.put("parentId", parentId);
		return JSONObject.toJSONString(json);
	}
}
