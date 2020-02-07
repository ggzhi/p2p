package com.xmg.p2p.base.query;

import java.util.ArrayList;
import java.util.List;

//分页查询结果对象
@SuppressWarnings("all")
public class PageResult {
	private List listData;// 当前页的结果集数据:查询
	private Integer totalCount;// 总数据条数:查询

	private Integer currentPage = 1;
	private Integer pageSize = 10;

	private Integer prevPage;// 上一页
	private Integer nextPage;// 下一页
	private Integer totalPage;// 总页数

	// 如果总数据条数为0,返回一个空集
	public static PageResult empty(Integer pageSize) {
		return new PageResult(new ArrayList<>(), 0, 1, pageSize);
	}
	
	public int getTotalPage(){
		return totalPage == 0 ? 1 :totalPage; 
	}

	public PageResult(List listData, Integer totalCount, Integer currentPage,
			Integer pageSize) {
		this.listData = listData;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		// ----------------------------------------
		this.totalPage = this.totalCount % this.pageSize == 0 ? this.totalCount
				/ this.pageSize : this.totalCount / this.pageSize + 1;

		this.prevPage = this.currentPage - 1 >= 1 ? this.currentPage - 1 : 1;
		this.nextPage = this.currentPage + 1 <= this.totalPage ? this.currentPage + 1
				: this.totalPage;
	}

	public void setListData(List listData) {
		this.listData = listData;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setPrevPage(Integer prevPage) {
		this.prevPage = prevPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List getListData() {
		return listData;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public Integer getPrevPage() {
		return prevPage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	
}
