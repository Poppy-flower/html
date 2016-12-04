package DBTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Select {
	

	public static void Select(String s) throws IOException {
		// TODO Auto-generated method stub
		String table_name="";//表名
		String line="";
		
		String[] x =s.split(" ");
		table_name=x[3];
		//System.out.println(table_name);
		File file = new File("D:\\"+table_name+".txt");
		if(file.exists()){
			BufferedReader br = new BufferedReader(new FileReader(file));
			line=br.readLine();
			System.out.println(line);
			while((line=br.readLine())!=null){
				String[] y =line.split(" ");
				for(int i=0;i<y.length;i++){
					System.out.print(y[i]+"|");
				}
				System.out.println();
			}
			System.out.println("成功执行");
		}else{
			System.out.println("此表不存在");
		}
	}
}
