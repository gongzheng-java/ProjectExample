package com.text.text;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;

public class Test {

	public static void main(String[] args) {
		 Frame frame =new Frame("My first windows");  
	        frame.setLayout(new GridLayout(7,1));  
	        //lable组件  
	        frame.add(new Label("喜好选择（可复选）："));  
	        //checkbox组件  
	        frame.add(new Checkbox("音乐"));  
	        frame.add(new Checkbox("体育"));  
	        frame.add(new Checkbox("美术"));  
	        //Choice 组件  
	        Choice c=new Choice();  
	        c.add("Red");  
	        c.add("Green");  
	        c.add("Blue");  
	        frame.add(c);  
	        //List组件  
	        List l=new List(3,false);  
	        l.add("一年级");  
	        l.add("二年级");  
	        l.add("三年级");  
	        frame.add(l);  
	        //Button组件   
	        frame.add(new Button("测试按钮"));  
	        frame.pack();//调整窗口以容纳所有的组件  
	        frame.setVisible(true);//显示窗口  
	        System.out.println("结束请按ctrl+c"); 
	}
}
