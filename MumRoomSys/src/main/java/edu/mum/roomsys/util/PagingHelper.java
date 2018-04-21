package edu.mum.roomsys.util;

import org.springframework.data.domain.Page;

public class PagingHelper<T> {
	private Page<T> page;
	private int currentPage;
	
	public PagingHelper(Page<T> p, int current) {
		page = p;
		setCurrentPage(current);
	}
	
	public int getNextPage() {
		if (page.hasNext()) {
			return page.nextPageable().getPageNumber();			
		}
		return -1;
	}
	
	public int getPreviousPage() {
		if (page.hasPrevious()) {
			return page.previousPageable().getPageNumber();			
		}
		return -1;
	}
	
	public int getTotalPage() {
		return page.getTotalPages();
	}	

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}
