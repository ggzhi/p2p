package com.xmg.p2p.base.event;

import org.springframework.context.ApplicationEvent;

import com.xmg.p2p.base.domain.RealAuth;

import lombok.Getter;

/**
 * 实名任组长审核通过的消息
 * @author 14847
 *
 */
@Getter
public class RealAuthSuccessEvent extends ApplicationEvent {
	
	/**
	 * 事件关联到的对象
	 */
	private RealAuth realAuth;
	
	public RealAuthSuccessEvent(Object source,RealAuth realAuth) {
		super(source); 
		this.realAuth= realAuth;
	}

}
