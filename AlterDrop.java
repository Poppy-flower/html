package DBTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlterDrop {

	public static void AlterDrop(String s) throws IOException{
		
		String result="";//������Ľ��
		String table_name = "";//����
		String s_analys="(\\w{1,16}) drop (.+) (.+)";
		String property="";
		String property_type="";
		String line ="";
		int weizhi=-1,count=0,count2=0;
		
		//�ֽ��ַ��� �������Լ�Ҫɾ�������Եõ�
		Pattern p = Pattern.compile(s_analys);
		Matcher m = p.matcher(s);
		while(m.find()){
			table_name = m.group(1).toString();
			property=m.group(2).toString();
			property_type=m.group(3).toString();
		}
		System.out.println(table_name+" "+property+"  "+property_type);
		
		File file = new File("D:\\"+table_name+".txt");
		if(file.exists()){
			BufferedReader br = new BufferedReader(new FileReader(file));
			result+=br.readLine()+"\r\n";//��ȡ��һ��
			line = br.readLine();
			//˼· ����ҵ��������򲻽���д���ļ� ����д���ļ�
			String[] y =line.split(" ");
			for(int i=0;i<y.length;i++){
				if(y[i].equals(property+"("+property_type.charAt(0)+")")){
					System.out.println("�ҵ�������");
					weizhi=i;//����ɾ�����Գ��ֵ�λ��
					//result+="\r\n"+line;
					count++;
				}else{
					result+=y[i]+" ";
				}				
			}
			System.out.println(weizhi+"λ��");
	
			System.out.println(result);
			System.out.println(1111);
			if(count==0){
				System.out.println("�ڴ˱���û�и�����");
			}
			while((line=br.readLine())!=null){
				String[] z= line.split(" ");
				result+="\r\n";//ÿһ��ǰ���л���
				count2++;
				if(line==""){
					System.out.println("�˱���û������");
				}
				if(count==0){
					result+=line;
					//����ԭ�����д���ļ�
				}else{
					for(int hh=0;hh<z.length;hh++){
						if(hh==weizhi){
							
						}else{
							result+=z[hh]+" ";
						}
					}
				}
				
				
			}
			System.out.println(result);
			if(count2==0){
				System.out.println("�˱���û������");
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
