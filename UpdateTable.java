package DBTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpdateTable {

	public static void UpdateTable(String s) throws IOException{
		//update student set name=xiaohua,ssn=2016,grade=����꼶  where grade=��һ�꼶;
		String result="";
		ArrayList<String> list=new ArrayList<String>();
		String s_analysis="(?<=set ).+(?=;)";
		String s_property="(.+)( where )(.+)";
		//String s_property_values="(?<=')(?=')";//�ֽ�����ֵ
		String s_update_values="(.+)=(.+),(.+)=(.+),(.+)=(.+)";
		String table_name="";//����
		String find = "" ;
		String values="";//whereǰ�������
		String values1="";//where���������
		String []x=s.split(" ");
		table_name=x[1];//����
		System.out.println(table_name);
		
		//�˰��ʵ���ж��Ƿ��дα�
		File file = new File("D:\\"+table_name+".txt");
		if(file.exists()){
			//�˰��ʵ�ֽ�set�����ʶ�����
			Pattern p = Pattern.compile(s_analysis);  
		    Matcher m = p.matcher(s);   
		    m.find();
		    find= m.group().toString();
		    System.out.println(find);
		    //�˰��ʵ�ֽ�where���ǰ�����Էֽ����
		    Pattern p1 = Pattern.compile(s_property);
		    Matcher m1 = p1.matcher(find);    
		    while(m1.find()){
		    	
		    	values=m1.group(1);
		    	values1=m1.group(3);
		    }
		    System.out.println(values);
		    System.out.println(values1);
		    //�˰��ʵ�ֽ���Ҫ�޸ĵ����Լ���ֵ�õ�
		    int weizhi=-1;//
		    String line="";
		    String[] y=values1.split("=");
		    String y_alter_property=y[0];//��Ҫ�޸ĵ�����
		    String y_alter_values=y[1];//��Ҫ�޸ĵ����Ե�ֵ
		    System.out.println(y_alter_values+"��Ҫ�޸�");
		    //�˰��ʵ�ֻ�ȡ���ĵ����Ժ�ֵ
		    BufferedReader br = new BufferedReader(new FileReader(file));
		    line=br.readLine();//��ȡ��һ��
		    result+=line+"\r\n";
		    list.add(line+"\r\n");//��ӵ�һ��
		    line=br.readLine();//��ȡ�ڶ���
		    result+=line+"";
		    list.add(line+"\r\n");//��ӵڶ���
		    //���ڶ��������ÿո�ֿ�
		    String[] h=line.split(" ");
		   
		    
		    for(int j=0;j<h.length;j++){
		    	//�õ���λ���Ե�λ��
		    	if(y_alter_property.equals(h[j].replaceAll("\\(.*?\\)",""))){
		    		weizhi=j;
		    		System.out.println(y_alter_property);
		    	}
		    }
		    System.out.println(weizhi+"");
		    
		    //ɸѡ���޸ĵ�ֵ������
		    String z ="";
		    Pattern p2 = Pattern.compile(s_update_values);
		    Matcher m2 = p2.matcher(values);    
		    m2.find();
		    for(int b=2;b<7;){
		    	z+=m2.group(b)+" ";
		    	b+=2;	    	
		    }
		    System.out.println(z+"lalal");
		    
		    //�ӵ����п�ʼ��
		    while((line=br.readLine())!=null){
		    	System.out.println(line);
		    	String[] k=line.split(" ");
		    	if(k==null){
		    		System.out.println("�˱���û��ֵ");
		    	}
		    	 //System.out.println(k[weizhi+1]+"��");
		    	else if(k[weizhi].equals(y_alter_values)){
		    		//���������ͬ ����Ҫ�ĵ���
		    		System.out.println("xiangtong");
		    		list.add(z+"\r\n");
		    		result+="\r\n"+z;
		    	}else{
		    		//û������ԭ���������д��
		    		list.add(line+"\r\n");
		    		result+="\r\n"+line;
		    	}
		    }
		    //���ַ���д���ļ���
		    System.out.println(result);
		    FileWriter fileWriter=new FileWriter("D:\\"+table_name+".txt", false);
		    fileWriter.write(result+"");
		    fileWriter.close();
		    System.out.println("�ɹ�ִ��");
		}else{
			System.out.println("�˱�����");
		}
		
	    
	    
//	    String[] y=find.split(" ");
//	    for(int i=0;i<y.length;i++){
//	    	System.out.println(y[i]);
//	    }
//	    int a=y[y.length-1].indexOf("=");
//	    System.out.println(a);
//	    System.out.println("���������ĸ����������"+y[y.length-1].substring(0, 3));
//	    String yy=y[y.length-1].substring(0, 3);
//	    String line ="";
//	    StringBuffer sBuffer=new StringBuffer();
//	    int i=2,h = 0;
//	    File file = new File("D:\\"+table_name+".txt");
	}
}
