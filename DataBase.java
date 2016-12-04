package DBTest;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataBase {
	 String sqlcreate="create table \\w{1,16} \\(.+\\)";
	 String sqlinsert="insert into (\\w{1,16}) \\((.+)\\) values\\((.+)\\)";
	 String sqlupdate="update .+set .+(where .+)?";
	 String sqldelete="delete from (\\w{1,16}) where .+";
	 String sqlselect="select \\* from (\\w{1,16})";
	 String sqlselecT="select (.+) from (\\w{1,16})";
	 String sqlselecX="select \\* from (.+) where (.+) (.+) (.+)";
	 String sqlselecXT="select (.+) from (.+) where (.+) (.+) (.+)";
	 //5��ʵ��������ϵ�Ͷ����ϵ�����Ӳ�����select * from ��ϵ���б� where ������������
	 //ѡ��������ָ�������� ������ ����������ʽ������ select * from A,B whereA.ID=B.ID 
	 String sqlselecL="select \\* from (.+) where (.+)";
	 String sqlalterA="alter table (\\w{1,16}) add (.+) (.+)";
	 String sqlalterD="alter table (\\w{1,16}) drop (.+) (.+)";
	 String sqldrop  ="drop table (\\w{1,16})";
	 String sqlindexU="create \\[(unique|clustered)\\] index (.+) on (.+)";
	public static void main(String[] args) throws IOException {
	
	    //String s="create table student (name char,ssn int,grade char)";
		//String s="insert into student (name,ssn,grade) values('˭˭˭', ,'��һ�꼶')";//bh 2016kong,
		//String s="update student set name=xiaohua,ssn=2016,grade=����꼶  where grade=��һ�꼶;";
		//String s ="delete from student where name=С��;";
		
		//String s = "alter table student add sex char";
		//String s = "alter table student drop ssn int";
		//String s="drop table student";
		//String s = "create [unique] index student_index on student";
		
		
		
		//cx
		//String s="select * from student";
	    //String s ="select name from student";//ty
		String s = "select * from student where ssn > '2013'";//xz
		//String s="select grade from student where ssn = '2014'";//xz+ty
		//String s = "select * from student,course where s.ssn=c.ssn";//lj
		
		
		//String s="create table course (c_name char,ssn int)";
		//String s="insert into course (c_name,ssn) values('���ݽṹ','2101')";
		//String s="create table study (grade char,ssn int)";
		//String s="insert into study (grade,ssn) values('��һ�꼶','2734')";
		//FileWriter file_system=new FileWriter("D://system_table.txt",true);
		//System.out.println(s.matches(sqlcreate));
		//String s = "select * from student,course,study where s.ssn=c.ssn=s.ssn";
		System.out.println("��ӭ��");
		System.out.println("�û�����");
		BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
		String username = brd.readLine();
		if("admin".equals(username)){
			System.out.println("���룺");
			BufferedReader brd2 = new BufferedReader(new InputStreamReader(System.in));
			String psw = brd2.readLine();
			if("admin".equals(psw)){
				System.out.println("��¼�ɹ�����ӭ�����Ա");
				System.out.println("�����");
				DataBase db = new DataBase();				
					db.admin(s);

			}
			else
				System.out.println("�������");
				return ;
				
		}

		else 
			if("user".equals(username)){
			System.out.println("���룺");
			BufferedReader brd2 = new BufferedReader(new InputStreamReader(System.in));
			String psw = brd2.readLine();
			if("user".equals(psw)){
				System.out.println("��¼�ɹ�����ӭ���û�");
				System.out.println("�����");
				DataBase db = new DataBase();
				
					db.user(s);
				
				
			}
			else
				System.out.println("�������");
			}
		
		
	}
	
	public void user(String s) throws IOException{
		 if(s.matches(sqlselect)){
			System.out.println("444");
			//file_system.write(s);
			Select.Select(s);
			//file_system.close();
		}else{
			System.out.println("��û�д�Ȩ�ޣ�");
		}
	}
	
	public void admin(String s) throws IOException{
		if(s.matches(sqlcreate)){
			System.out.println("000");
			//file_system.write(s);
			CreateTable.CreateTable(s);
			//file_system.close();
		}
		else if(s.matches(sqlinsert)){
			System.out.println("111");
			//file_system.write(s);
			InsertValues.InsertValues(s);
			//file_system.close();
		}
		else if(s.matches(sqlupdate)){
			//����һ�����Ը��±�
			System.out.println("222");
			//file_system.write(s);
			UpdateTable.UpdateTable(s);
			//file_system.close();
		}
		else if(s.matches(sqldelete)){
			System.out.println("333");
			//file_system.write(s);
			DeleteLine.DeleteLine(s);
			//file_system.close();
		}
		else if(s.matches(sqlselect)){
			System.out.println("444");
			//file_system.write(s);
			Select.Select(s);
			//file_system.close();
		}
		else if(s.matches(sqlalterA)){
			System.out.println("555");
			//file_system.write(s);
			AlterAdd.AlterAdd(s);
			//file_system.close();
		}
		else if(s.matches(sqlalterD)){
			System.out.println("666");
			//file_system.write(s);
			AlterDrop.AlterDrop(s);
			//file_system.close();
		}
		else if(s.matches(sqldrop)){
			System.out.println("777");
			//file_system.write(s);
			DropTable.DropTable(s);
			//file_system.close();
		}
		else if(s.matches(sqlindexU)){
			System.out.println("888");
			//file_system.write(s);
			IndexTable.IndexTable(s);;
			//file_system.close();
		}
		else if(s.matches(sqlselecT)){
			System.out.println("999");
			Select_2.Select_2(s);
		}
		else if(s.matches(sqlselecX)){
			System.out.println("101010");
			Select_x.Select_x(s);
		}else if(s.matches(sqlselecXT)){
			System.out.println("111111");
			Select_xt.Select_xt(s);
		}
		else if(s.matches(sqlselecL)){
			System.out.println("121212");
			Select_L.Select_L(s);
		}
		else{
			System.out.println("���������д���");
		}
	}
}
