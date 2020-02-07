package com.xmg.p2p.base.event;

import org.springframework.context.ApplicationEvent;

import com.xmg.p2p.business.domain.RechargeOffline;

import lombok.Getter;

@Getter
public class RechargeOfflineSuccessEvent extends ApplicationEvent {
	
	private RechargeOffline ro;
	
	public RechargeOfflineSuccessEvent(Object source,RechargeOffline ro) {
		super(source);
		this.ro = ro;
		
			}

	
}
