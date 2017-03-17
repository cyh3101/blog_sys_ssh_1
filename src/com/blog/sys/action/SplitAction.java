package com.blog.sys.action;

import com.blog.sys.entity.Split_Chinese;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by paddy on 2017/3/17.
 */
public class SplitAction extends ActionSupport{
	private String getTxt;
	
	
	public String split_chinese() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest ();
		Split_Chinese split_chinese = new Split_Chinese();
		getTxt.getBytes ("utf-8");
		System.out.println (getTxt );
		List<String> result = new ArrayList<String> ( );
		split_chinese.split_Chinese (getTxt, result);
		System.out.println (result );
		String sendSplit ="";
		for (String i : result) {
			sendSplit = sendSplit + '/' + i;
		}
		sendSplit.getBytes ("utf-8");
		request.getSession ().setAttribute ("sendSplit", sendSplit);
		return SUCCESS;
	}
	
	public String getGetTxt () {
		return getTxt;
	}
	
	public void setGetTxt (String getTxt) {
		this.getTxt = getTxt;
	}
}
