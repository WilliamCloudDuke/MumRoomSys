package edu.mum.roomsys.dto;

public class PageDto {
	private int currentPage;
	private int nextPage;
	private int previousPage;
	private int totalPage;
	
	public PageDto(int currentPage, int nextPage, int previousPage, int totalPage) {
		super();
		this.currentPage = currentPage;
		this.nextPage = nextPage;
		this.previousPage = previousPage;
		this.totalPage = totalPage;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getPreviousPage() {
		return previousPage;
	}
	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
