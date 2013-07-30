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
	
}

