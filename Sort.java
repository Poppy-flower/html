package DBTest;

import java.io.FileWriter;
import java.io.IOException;

public class Sort {
//∞¥’’◊÷µ‰≈≈–Ú
	public static void Sort(String[] strArray,String index_name) throws IOException{
		// strArray = new String[]{"red","yellow","Black","Green"};
		String t = null;
		System.out.println("≈≈–Ú«∞");
		for(String s : strArray)
			System.out.print(s+"\t");
		int i,j,k,f;

		for(i=0;i<strArray.length; i++)
			{
				k=i;
				for(j=i+1;j<strArray.length;j++)
				{
					Character c1 = Character.valueOf(strArray[j].charAt(0));
					Character c2 = Character.valueOf(strArray[k].charAt(0));
					if(c1.compareTo(c2)<0)
						k=j;
				}
					if(i!=k)
					{
						t=strArray[i];
						strArray[i]=strArray[k];
						strArray[k]=t;
					}
			}
		
		System.out.println("\n≈≈–Ú∫Û:");
		
		FileWriter filewriter = new FileWriter("D:\\"+index_name+".txt",false);
		for(String s : strArray){
			System.out.print(s+"\t");
			filewriter.write(s+"\r\n");
		}
			
		filewriter.close();
	}
	
	
}
