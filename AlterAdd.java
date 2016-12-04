package DBTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlterAdd {


	public static void AlterAdd(String s) throws IOException {
		// TODO Auto-generated method stub
		String result="";
		String table_name="";
		String property="";
		String property_type="";
		String s_analys="(\\w{1,16}) add (.+) (.+)";
		String line= "";
		int count=0;
		
		Pattern p = Pattern.compile(s_analys);
		Matcher m = p.matcher(s);
		while(m.find()){
			table_name = m.group(1).toString();
			property=m.group(2).toString();
			property_type=m.group(3).toString();
		}
		System.out.println(table_name+"    "+property+"("+property_type.charAt(0)+")");
		
		File file = new File("D:\\"+table_name+".txt");
		if(file.exists()){
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			result+=br.readLine();
			line = br.readLine();
			String[] y =line.split(" ");
			for(int i=0;i<y.length;i++){
				if(y[i].equals(property+"("+property_type.charAt(0)+")")){
					System.out.println("�������Ѿ�����");
					result+="\r\n"+line;
					
				}else{
					count++;
				}
				
			}
			if(count==y.length){
					result+="\r\n"+line+property+"("+property_type.charAt(0)+")";
					System.out.println("���Գɹ��������");
				}
			while((line=br.readLine())!=null){
				result+="\r\n"+line+" null";
			}
			
			System.out.println(result);
	        FileWriter fileWriter=new FileWriter("D:\\"+table_name+".txt", false);
	        fileWriter.write(result+"");
	        fileWriter.close();
	        System.out.println("�ɹ�ִ��");
		}else{
			System.out.println("�˱�����");
		}
	}

}
