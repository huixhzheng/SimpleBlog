package com.duell.blogging.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

public class UIBlogEntry {
	
	private Integer id;

	private String title;

	private String content;
	
	private String author;
	
	private String author_contact;
	
	private Date publish_date;
	
	private Collection<UITag> tags;
	
	private Collection<UIComment> comments;
	
	private byte[] imageBytes;
	
	private String imageURI = null;
	
	public UIBlogEntry()
	{
		imageURI = "SimpleBlog/images/lakemountain_532_290.png";
	}
	public UIBlogEntry(UIBlogEntry that)
	{
		this.id=that.id;
		this.title=that.title;
		this.content=that.content;
		this.author=that.author;
		this.author_contact=that.author_contact;
		this.publish_date=that.publish_date;
		
		
		File f = new File("SimpleBlog/images/lakemountain_532_290.png");
		long size = f.getTotalSpace();
		imageBytes = new byte[(int)size];
		

		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream(f);
			fis.read(imageBytes);
			
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			imageBytes = null;
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			imageBytes = null;
		}
		finally
		{
			try
			{
				if(fis!=null)
				{
					fis.close();
				}
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
	
	public byte[] getImageBytes()
	{
		return imageBytes;
	}
	
	public void setImageBytes(byte[] imageBytes)
	{
		this.imageBytes = imageBytes;
	}
	
	
	public String getImageURI()
	{
		return imageURI;
	}
	
	public void setImageURI(String imageURI)
	{
		this.imageURI = imageURI;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor_contact() {
		return author_contact;
	}

	public void setAuthor_contact(String author_contact) {
		this.author_contact = author_contact;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	public Collection<UITag> getTags() {
		return tags;
	}
	public void setTags(Collection<UITag> tags) {
		this.tags = tags;
	}
	public Collection<UIComment> getComments() {
		return comments;
	}
	public void setComments(Collection<UIComment> comments) {
		this.comments = comments;
	}
	@Override
	public String toString()
	{
		return "UIBlogEntry [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author
				+ ", author_contact=" + author_contact + ", publish_date=" + publish_date + ", tags=" + tags + ", comments="
				+ comments + ", imageBytes=" + Arrays.toString(imageBytes) + ", imageURI=" + imageURI + "]";
	}
	
	
}
