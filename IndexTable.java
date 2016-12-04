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
			System.out.println("unique类型");
			IndexKeyTable(s);
		}else{
			System.out.println("clustered类型");
			
		}
	}
	public static void clusteredTable(String s){
		
	}
	//默认主键为学号
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
		System.out.println("索引表名"+index_name+"表名"+table_name);
		File file = new File("D:\\"+table_name+".txt");
		File file2= new File("D:\\"+index_name+".txt");
		
		FileWriter fileWriter=new FileWriter("D:\\"+index_name+".txt", true);
		FileWriter fileWriter2=new FileWriter("D:\\"+index_name+".txt", false);
		if(file.exists()){//判断表是否存在
			if(file2.exists()){
				//如果索引表存在 则先删除
				fileWriter2.write("");
				fileWriter2.close();
			}
				//file2.delete();
			//读取文件
				BufferedReader br = new BufferedReader(new FileReader(file));
				br.readLine();//读第一行
				line = br.readLine();//读第二行
				String[] x =line.split(" ");
				for(int i=0;i<x.length;i++){
					if(x[i].equals("ssn(i)")){
						//如果是主键 记下位置
						weizhi=i;
					}
				}
				//一次从第三行读起
				while((line=br.readLine())!=null){ 
					count++;
					String[] y=line.split(" ");
					fileWriter.write(y[weizhi]+count+"\r\n");
					//将主键和其行数写入索引文件中
				}
				fileWriter.close();
			
				System.out.println(count+"行");
				String[] array = new String[count];
				int tt=0;
			//获取索引表中内容
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
			System.out.println("此表不存在");
		}
	}
}
