package cn.model;
/**
 * 
 * @ClassName:  Message   
 * @Description:TODO(留言内容实例)   
 * @author: ydc
 * @date:   2018年12月4日 上午11:34:26   
 *     
 * @Copyright: 2018 ydc All rights reserved. 
 *
 */
public class Message {
	String content;
	String id;
	String title;
	String date;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate()
	{
		return this.date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDate(String date)
	{
		this.date=date;
	}
	public Message(String content, String id, String title) {
		this.content = content;
		this.id = id;
		this.title = title;
	}
	public   Message() {
		// TODO Auto-generated constructor stub {
		this.content=null;
		this.id=null;
		this.title=null;
		this.date=null;
	}
	
	
	
	
}
