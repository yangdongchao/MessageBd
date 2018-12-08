package cn.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cn.Dao.LoginDb;
import cn.model.User;

class LoginDbTest {

	@Test
	void test() {
		System.out.println("aaaa");
		User tmp= new User();
	    tmp =LoginDb.queryById("123");
	    if(tmp==null)
	    {
	    	System.out.println("No");
	    }
	    else
	    {
	    	System.out.println("Yes");
	    }
		System.out.println(tmp.getName());
		fail("Not yet implemented");
	}

}
