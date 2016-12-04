package DBTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IndexTable {

	public static void IndexTable(String s) throws IOException{
		//create [unique] index student_index on student
		String type="";
		String s_analyis ="\\[(unique|clustered)\\] index (.+) on (.+)";
		Pattern p = Pattern.compile(s_analyis);
		Matcher m = p.matcher(s);
		while(m.find()){
			type=m.group(1).toString();
			System.out.println(type);
		}
		if(type.equals("unique")){
			System.out.println("unique����");
			IndexKeyTable(s);
		}else{
			System.out.println("clustered����");
			
		}
	}
	public static void clusteredTable(String s){
		
	}
	//Ĭ������Ϊѧ��
	public static void IndexKeyTable(String s) throws IOException{
		//ArrayList<String> arrylist = new ArrayList<E>();
		String s_analyis ="\\[(unique|clustered)\\] index (.+) on (.+)";
		String table_name="";
		String index_name="";
		String line="";
		int weizhi=-1,count=0;
		
		 
		Pattern p = Pattern.compile(s_analyis);
		Matcher m = p.matcher(s);
		while(m.find()){
			index_name=m.group(2).toString();
			table_name=m.group(3).toString();
		}
		System.out.println("��������"+index_name+"����"+table_name);
		File file = new File("D:\\"+table_name+".txt");
		File file2= new File("D:\\"+index_name+".txt");
		
		FileWriter fileWriter=new FileWriter("D:\\"+index_name+".txt", true);
		FileWriter fileWriter2=new FileWriter("D:\\"+index_name+".txt", false);
		if(file.exists()){//�жϱ��Ƿ����
			if(file2.exists()){
				//������������ ����ɾ��
				fileWriter2.write("");
				fileWriter2.close();
			}
				//file2.delete();
			//��ȡ�ļ�
				BufferedReader br = new BufferedReader(new FileReader(file));
				br.readLine();//����һ��
				line = br.readLine();//���ڶ���
				String[] x =line.split(" ");
				for(int i=0;i<x.length;i++){
					if(x[i].equals("ssn(i)")){
						//��������� ����λ��
						weizhi=i;
					}
				}
				//һ�δӵ����ж���
				while((line=br.readLine())!=null){ 
					count++;
					String[] y=line.split(" ");
					fileWriter.write(y[weizhi]+count+"\r\n");
					//��������������д�������ļ���
				}
				fileWriter.close();
			
				System.out.println(count+"��");
				String[] array = new String[count];
				int tt=0;
			//��ȡ������������
				FileWriter fileWriter3=new FileWriter("D:\\"+index_name+".txt", true);
				BufferedReader br1 = new BufferedReader(new FileReader(file2));
				while((line=br1.readLine())!=null){
					//String[] sz=line.split(" ");
					//array[tt]=sz[0];
					array[tt]=line;
					//System.out.println(array[tt]);
					//arrylist.add(sz[0]);
					tt++;
				}
				int[] yy = new int[tt];
				for(int xx=0;xx<array.length;xx++){
					
					yy[xx]=Integer.parseInt(array[xx]);
				}
				//shiyan1.Sort.Sort2(yy,index_name);
				//Sort.Sort(array,index_name);
				//arrylist.sort(c);
		}else{
			System.out.println("�˱�����");
		}
	}
}
