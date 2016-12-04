package DBTest;

import java.io.File;

public class DropTable {

	public static void DropTable(String s){
		
		String table_name="";
		String[] x =s.split(" ");
		table_name=x[2];
		System.out.println("表名"+table_name);
		File file = new File("D:\\"+table_name+".txt");
		if(file.exists()){
			if(file.delete()){
			System.out.println("成功删除");
		    }else{
			System.out.println();
		   }
		
		}else{
			System.out.println("不存在此表");
		}
		
		}
}
