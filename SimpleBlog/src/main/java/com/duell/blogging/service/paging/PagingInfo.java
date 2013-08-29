package com.duell.blogging.service.paging;

/**
 * For control of which/how many entries to pull back from the DB to the UI.
 * @author duellmat
 *
 */
public class PagingInfo {

	private int pageNum = -1;
	private int entriesPerPage = 5;
	private int startEntry=-1;
	private int endEntry=-1;
	
	private boolean hasNext = false;
	
	public int getPrevPage()
	{
		return pageNum-1;
	}
	public int getNextPage()
	{
		return pageNum+1;
	}
	
	public boolean getHasNext() {
		return hasNext;
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	public PagingInfo()
	{
	}
	public PagingInfo(int page,int entriesPerPage)
	{
		this.pageNum = page;
		this.entriesPerPage = entriesPerPage;
	}
	
	public int getStartEntry() {
		return startEntry;
	}
	public void setStartEntry(int startEntry) {
		this.startEntry = startEntry;
	}
	public int getEndEntry() {
		return endEntry;
	}
	public void setEndEntry(int endEntry) {
		this.endEntry = endEntry;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getEntriesPerPage() {
		return entriesPerPage;
	}
	public void setEntriesPerPage(int entriesPerPage) {
		this.entriesPerPage = entriesPerPage;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + endEntry;
		result = prime * result + entriesPerPage;
		result = prime * result + (hasNext ? 1231 : 1237);
		result = prime * result + pageNum;
		result = prime * result + startEntry;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PagingInfo other = (PagingInfo) obj;
		if (endEntry != other.endEntry)
			return false;
		if (entriesPerPage != other.entriesPerPage)
			return false;
		if (hasNext != other.hasNext)
			return false;
		if (pageNum != other.pageNum)
			return false;
		if (startEntry != other.startEntry)
			return false;
		return true;
	}	
}

