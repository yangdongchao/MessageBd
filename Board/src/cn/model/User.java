package cn.model;

import com.sun.org.apache.xerces.internal.impl.dv.ValidatedInfo;

import cn.Dao.LoginDb;
import cn.control.LoginControl;

/**
 * 
 * @ClassName:  User   
 * @Description:TODO(用户实体类，作为中间体实现数据库与前端的交互)   
 * @author: ydc
 * @date:   2018年12月4日 上午11:24:52   
 *     
 * @Copyright: 2018 ydc All rights reserved. 
 *
 */
public class User {
	public  String id;
	public  String name;
	public  String sex;
	public  String password;
	//图片先保留
	public static void main(String [] args) {
		boolean f=LoginControl.check("123", "123");
		User tmp =LoginDb.queryById("123");
		System.out.println(tmp.getName());
		if(f==true)
		{
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
	public String getId() {
		return id;
	}
	public  void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String id, String name, String sex, String password) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.password = password;
	}
	public User()
	{
		this.id=null;
		this.name=null;
		this.sex = null;
		this.password = null;
	}
}
