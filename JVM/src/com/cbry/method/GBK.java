package com.cbry.method;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GBK {
	public static void main(String[] args) {
		try
		{
		FileInputStream fis = new FileInputStream("C:/Users/廖兴广/Desktop/monProc_DataSourceAccessGD.sh");
		InputStreamReader isr = new InputStreamReader(fis);
		FileOutputStream fos = new FileOutputStream("C:/Users/廖兴广/Desktop/monProc_DataSourceAccessGD_GBK.sh");
		OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");
		int s;
		while((s = isr.read()) != -1) {
		osw.write(s);
		//System.out.println(s);
		}
		osw.flush();
		osw.close();
		isr.close();
		System.out.println("写入完成！");
		}catch (IOException e){
		e.printStackTrace();
		}
		}
}
