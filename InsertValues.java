package DBTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsertValues {

	public static void InsertValues(String s) throws IOException{
		//事例 insert into student (name,ssn,grade) values('李雪','1234','大一年级')
		String s_property="(?<=').+?(?=')";//分辨属性
		String find = "" ;//保留属性的值  事例 李雪 1234 大一年级
		String table_name="";//表名
		String []x=s.split(" ");
		String line="";
		Boolean flag = true;
		
		table_name=x[2];
		File file = new File("D:\\"+table_name+".txt");
		FileWriter file_system=new FileWriter("D://system_table.txt",true);
		//File index_file=new File("D:\\"+table_name+"_index.txt");//索引文件
		System.out.println(table_name);
		file_system.write("表"+table_name+"插入数据 ");
	    
	    if(file.exists()){//判断文件是否存在
	    	
	    Pattern p = Pattern.compile(s_property);  
	    Matcher m = p.matcher(s);
	    
	    while(m.find()){
	    	 find+= m.group().toString();    
	    	 //System.out.println(m.group());
	    }
	    System.out.println(find);
	  //  System.out.println(find.substring(4,find.length()));
	    
	    String []result=find.split(",");
	    FileWriter fileWriter=new FileWriter("D:\\"+table_name+".txt", true);
	    fileWriter.write("\r\n");
	    BufferedReader b = new BufferedReader(new FileReader(file));
	    b.readLine();
	    b.readLine();
	    
	    while((line=b.readLine())!=null){
	    	String[] t=line.split(" ");
	    	//System.out.println(result[1]+"zhehis"+t[1]+"sdsd");
	    	if(result[1].equals(t[1])){
	    		flag=false;
	    		System.out.println("主键不能重复");
	    		break;
	    	}
	    	if(result[1].equals(" ")){
	    		System.out.println("主键不能为空");
	    		flag=false;
	    		break;
	    	}
	    	
	    }
	    if(flag){
	    	//将值加入到文件中
	    for(int i=0;i<result.length;i++){
	    	fileWriter.write(result[i]+" ");
	    	file_system.write(result[i]+" ");
	    }
	    System.out.println("成功添加");
	    fileWriter.close();
	    System.out.println("成功执行");
	    file_system.write("\r\n");
	    file_system.close();
	    }
	   
	    } else{
	    	System.out.println("不存在此表");
	    }
	    
		
	}
}
