package DBTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Select_xt {

	public static void Select_xt(String s) throws IOException{
		
		String table_name="";
		String s_analys="select (.+) from (.+) where (.+) (.+) (.+)";
		String proper="";//ͶӰ������
		String property="";//����
		String operator="";//�����
		String prop_value="";//����ֵ
		String line = "";
		String result="";
		int weizhi=-1,weizhi2=-1,ssn;
		
		Pattern p = Pattern.compile(s_analys);
		Matcher m = p.matcher(s);
		while(m.find()){
			proper=m.group(1).toString();
			table_name = m.group(2).toString();
			property=m.group(3).toString();
			operator=m.group(4).toString();
			prop_value=m.group(5).substring(1,m.group(5).length()-1);
		}
		
		System.out.println(proper+" "+table_name+" "+property+" "+operator+" "
				+prop_value);
		
		File file = new File("D://"+table_name+".txt");
		if(file.exists()){
			BufferedReader bf = new BufferedReader(new FileReader(file));
			bf.readLine();//��ȡ��һ��
			//��ȡ�ڶ��� ���ҵ��������ļ��е�λ�� 
			line=bf.readLine();
			String[] x= line.split(" ");
			for(int i=0;i<x.length;i++){
				if(property.equals(x[i].replaceAll("\\(.*?\\)",""))){
			   		weizhi=i;
				}
			}
			for(int i=0;i<x.length;i++){
				if(proper.equals(x[i].replaceAll("\\(.*?\\)",""))){
			   		weizhi2=i;
				}
			}
			result=proper+"\r\n";
			ssn=Integer.parseInt(prop_value);
			while((line=bf.readLine())!=null){
				String[] y =line.split(" ");
			if(operator.equals("=")){
				if(Integer.parseInt(y[weizhi])==ssn){
					result+=y[weizhi2]+"\r\n";
					//System.out.println("2222");
				}
			}else if(operator.equals(">=")){
				if(Integer.parseInt(y[weizhi])>=ssn){
					result+=y[weizhi2]+"\r\n";
					//System.out.println("3333");
				}
			}else if(operator.equals("<=")){
				if(Integer.parseInt(y[weizhi])<=ssn){
					result+=y[weizhi2]+"\r\n";
					//System.out.println("3333");
				}
			}else if(operator.equals("<")){
				if(Integer.parseInt(y[weizhi])<ssn){
					result+=y[weizhi2]+"\r\n";
					//System.out.println("3333");
				}
			}else if(operator.equals(">")){
				if(Integer.parseInt(y[weizhi])>ssn){
					result+=y[weizhi2]+"\r\n";
					//System.out.println("3333");
				}
			}else if(operator.equals("!=")){
				if(Integer.parseInt(y[weizhi])!=ssn){
					result+=y[weizhi2]+"\r\n";
					//System.out.println("3333");
				}
			}else{
				System.out.println("��ʱ��֧�ִ˱ȽϷ��Ĳ�ѯ");
			}
				
			}
			System.out.println(result);
		}else{
			System.out.println("�����ڴ˱�");
		}
	}
}
