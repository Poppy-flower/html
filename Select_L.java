package DBTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Select_L {

	public static void Select_L(String s) throws IOException{
		//select * from student,course where s.ssn=c.ssn
		String s_analys="select \\* from (.+) where (.+)";
		String s_connect="(=|<|>|<=|>=|!=)";//Ŀǰ��֧��>=  <= !=
		String table_list="";//����
		String connect_con="";//���� s.name=c.name
		ArrayList<File> list = new ArrayList();//List�б���File����
		String line="";
		String line1="";
		String line2="";
		int weizhi=-1,weizhi2=-1;
		String result="";
		
		Pattern p = Pattern.compile(s_analys);
		Matcher m = p.matcher(s);
		while(m.find()){
			table_list=m.group(1).toString();
			connect_con=m.group(2).toString();
		}
		System.out.println("connect_con"+connect_con);
		String[] x=table_list.split(",");//�����Ϸֿ�
		String[] y=connect_con.split(s_connect);//����ϵ�ֿ�
		//����
		for(int i=0;i<x.length;i++){
			System.out.println(x[i]);
		}
		//����
		for(int i=0;i<y.length;i++){
			System.out.println(y[i]);
		}
		System.out.println(connect_con.substring(y[0].length(),y[0].length()+1));
		//˼�� ��list�����ļ�����
		String[] context = new String[y.length];
		for(int i=0;i<x.length;i++){
			System.out.println();
			File file = new File("D://"+x[i]+".txt");
			list.add(file);
			//ԭ���뽫���ݷ����ַ���������  ������ԭ���뷨
			if(file.exists()){
				BufferedReader bf = new BufferedReader(new FileReader(file));
				while((line=bf.readLine())!=null){
					//System.out.println(line);
					context[i]+=line+"\r\n";
				}
			}else{
				System.out.println(x[i]+"������");
			}
		}
		
		for(int i=0;i<x.length;i++)
			System.out.println(context[i]);
		System.out.println(y[0].substring(2,y[0].length()));
        //����Ϊԭ���뷨
//		for(int i=0;i<x.length;i++){
//			
//		}
		
		FileWriter temp_file=new FileWriter("D://temp.txt",false);
		result+="\r\n";
		result+="\r\n";
		BufferedReader bf1 = new BufferedReader(new FileReader(list.get(0)));
		BufferedReader bf2 =new BufferedReader(new FileReader(list.get(1)));
		bf1.readLine();
		bf2.readLine();
		line1=bf1.readLine();
		String[] t =line1.split(" ");
		System.out.println(t[1].replaceAll("\\(.*?\\)",""));
		for(int i=0;i<t.length;i++){
			if((t[i].replaceAll("\\(.*?\\)","")).equals(y[0].substring(2,y[0].length()))){
				weizhi=i;
				System.out.println(weizhi);
			}
		}
		line2=bf2.readLine();
		String[] t2 =line1.split(" ");
		//System.out.println(t2[1].replaceAll("\\(.*?\\)",""));
		for(int i=0;i<t.length;i++){
			if((t2[i].replaceAll("\\(.*?\\)","")).equals(y[0].substring(2,y[0].length()))){
				weizhi2=i;
				System.out.println(weizhi2);
			}
		}
		
		while((line1=bf1.readLine())!=null){
				bf2 =new BufferedReader(new FileReader(list.get(1)));
				bf2.readLine();
				bf2.readLine();
			
			String[] rr = line1.split(" ");
			//System.out.println(rr[weizhi]);
			while((line2=bf2.readLine())!=null){
				String[] rr2= line2.split(" ");
				//System.out.println("2"+rr2[weizhi2]);
				if(rr[weizhi].equals(rr2[weizhi2])){
				
				result+=line1+rr2[weizhi2-1]+"\r\n";//!!!!
				//System.out.println(result);
				
				//System.out.println("1212121");
			   }
				
			}
						
		}
		temp_file.write(result);
		temp_file.close();
		BufferedReader b = new BufferedReader(new FileReader("D://temp.txt"));
		while((line=b.readLine())!=null){
			System.out.println(line);
		}
		//System.out.println(result);
	}
}
