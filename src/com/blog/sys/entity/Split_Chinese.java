package com.blog.sys.entity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by paddy on 2017/3/17.
 */
public class Split_Chinese {
	
	//字典位置
	private File dict_data_path = new File ("F:\\java_project\\blog_sys_ssh_1\\src\\data_baidu.txt");
	private List<String> dict_data;
	public Split_Chinese() throws IOException {
		this.init();
	}
	
	private void init() throws IOException {
		dict_data = new ArrayList<String> ( );
		FileInputStream fileInputStream = new FileInputStream (dict_data_path);
		InputStreamReader inputStream = new InputStreamReader (fileInputStream, "utf-8");
		BufferedReader bufferedReader = new BufferedReader (inputStream);
		String lineTxt = null;
		while ((lineTxt = bufferedReader.readLine ( )) != null) {
			dict_data.add (lineTxt);
		}
		inputStream.close ();
	}
	
	
	private boolean InDict (String txt, List<String> dict_data) {
		
		for (String j : dict_data) {
			if (txt.equals (j)) {
				return true;
			}
		}
		return false;
	}
	
	public void split_Chinese(String txt, List<String> result){
		if (txt.length ( ) >= 3) {
			if (InDict (txt.substring (0, 3), dict_data)) {
				result.add (txt.substring (0, 3));
				txt = txt.substring (3, txt.length ());
				split_Chinese (txt, result);
				
			}
			else if (InDict (txt.substring (0, 2), dict_data)) {
				result.add (txt.substring (0, 2));
				txt = txt.substring (2, txt.length ( ));
				split_Chinese (txt, result);
			} else {
				result.add (txt.substring (0, 1));
				txt = txt.substring (1, txt.length ( ));
				split_Chinese (txt, result);
			}
			
		} else if (txt.length ( ) == 2) {
			if (InDict (txt, dict_data)) {
				result.add (txt);
				txt = null;
				
			} else {
				result.add (txt.substring (0, 1));
				result.add (txt.substring (1, 2));
				txt = null;
			}
		} else if (txt.length () == 1){
			result.add (txt);
			txt = null;
		}
	}
	
	
}
