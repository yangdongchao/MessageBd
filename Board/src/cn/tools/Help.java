package cn.tools;

import java.io.UnsupportedEncodingException;

public class Help {
	public static String utf8(String tmp) 
    {
		try {
			return new String(tmp.getBytes("utf-8"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmp;
	}

	
}
