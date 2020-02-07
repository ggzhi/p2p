package com.xmg.p2p.base.query;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
abstract public class QueryObject {

	private Integer currentPage = 1;
	private Integer pageSize = 5; 

	public int getStart(){
		return (currentPage - 1) * pageSize;
	}
}
