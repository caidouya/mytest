package edu.bdqn.ssm.util;

import java.util.List;

/**
 * 集合分页
 * 
 * @author Cc.liu
 *
 */
public class Pager<T> {
	// 需要分页的集合
	private List<T> list;
	// 显示的总记录数
	private Integer totalNum;
	// 总页数
	private Integer totalPage;
	// 当前页
	private Integer currentPage;
	// 每页显示的数目
	private Integer pageSize;

	// start=1 pageNo=3，页码显示如：1，2，3
	private Integer start;// 起始页码

	public Pager(Integer totalNum, Integer currentPage, Integer pageSize) {
		this.totalNum = totalNum;
		this.currentPage = currentPage;
		this.pageSize = pageSize;

		// 计算总页数
		this.totalPage = totalNum % this.pageSize == 0 ? totalNum
				/ this.pageSize : (totalNum / this.pageSize) + 1;

		this.start = currentPage;
		// 如设置为3条，如果总页数都只有2条，则全部显示
		//this.pageNo = pageNo + currentPage - 1 >= this.totalPage ? pageNo
		//		: this.totalPage - currentPage + 1;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

//	public Integer getPageNo() {
//		return pageNo;
//	}
//
//	public void setPageNo(Integer pageNo) {
//		this.pageNo = pageNo;
//	}

	@Override
	public String toString() {
		return "Pager [list=" + list + ", totalNum=" + totalNum
				+ ", totalPage=" + totalPage + ", currentPage=" + currentPage
				+ ", pageSize=" + pageSize + ", start=" + start + "]";
	}
	

}