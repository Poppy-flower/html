package DBTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Select_2 {

	public static void Select_2(String s) throws IOException{
		
		String table_name="";
		String s_analys="select (.+) from (\\w{1,16})";//���������� ������
		String property="";//������
		String line="";
		String result="";
		int weizhi=-1;
		
		Pattern p = Pattern.compile(s_analys);
		Matcher m = p.matcher(s);
		while(m.find()){
			table_name=m.group(2).toString();
			property=m.group(1).toString();
		}
		System.out.println(table_name+"  "+property);
		
		File file = new File("D://"+table_name+".txt");
		
		if(file.exists()){
		
			BufferedReader bf =new BufferedReader(new FileReader(file));
			bf.readLine();//��ȡ��һ��
			line=bf.readLine();//��ȡ�ڶ���
			String[] x=line.split(" ");
			//�ҵ���Ӧλ��
			for(int i=0;i<x.length;i++){
				if(property.equals(x[i].replaceAll("\\(.*?\\)",""))){
			   		weizhi=i;
				}
			}
			while((line=bf.readLine())!=null){
				String[] y = line.split(" ");
				result+=y[weizhi]+"\r\n";
			}
			
			System.out.println("name(c)");
			System.out.println(result);
			
		}else{
			System.out.println("�˱�����");
		}
	}
}
