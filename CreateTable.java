package DBTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateTable {

	public static void CreateTable(String s) throws IOException{
		
		//���� create table student (name char,ssn int,grade char)
		String table_name="";//����
		String parm_shuxing="";//������
		String s_parm_shuxing="(?<=\\().+(?=\\))";
		File file = new File("D:\\"+table_name+".txt");
		FileWriter file_system=new FileWriter("D://system_table.txt",true);
		
		String []x=s.split(" ");//���ÿո�ָ�
		table_name=x[2];//����  ���� student
		
		if(file.exists()){
			System.out.println("�ñ��Ѿ�����");
		}
		else{
			FileWriter fileWriter=new FileWriter("D:\\"+table_name+".txt", true);
			fileWriter.write(table_name+"\r\n");//������д���ļ���
			file_system.write("������:"+table_name+" ");
			//����������ʽƥ�� �õ������е�����
			Pattern p = Pattern.compile(s_parm_shuxing);  
		    Matcher m = p.matcher(s);
		   // System.out.println(m);
		    m.find();
		    parm_shuxing  = m.group().toString();
		    System.out.println(parm_shuxing);//����  name char,ssn int,grade char
		      	       
		    String[] y=parm_shuxing.split(",");
		    String z[]=new String[y.length*2];
		      
		    for(int i=0;i<y.length;i++){
		    	z=y[i].split(" ");
		    	System.out.println(z[0]);//�õ�����,�ָ�ĵ�һ����
		    	//���� name ssn grade
		    	fileWriter.write(z[0]+"("+z[1].charAt(0)+") ");
		    	//���� name(c)
		    	file_system.write("���� "+z[0]+" ����  "+z[1]);
		    }
		    System.out.println("������ɹ�\n");
		    file_system.write("\r\n");
		    fileWriter.close();
		    file_system.close();
		}
		
	}
}
