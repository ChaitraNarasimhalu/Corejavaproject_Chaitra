package Hotel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.Scanner;


public class CustomerViewSection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
	       	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			  Statement statement=con.createStatement();
			  Statement statement2=con.createStatement();
			  Statement statement3=con.createStatement();
			  
			  ResultSet rs=statement.executeQuery("SELECT * FROM mydb.hoteldetails");
			  while(rs.next())
			  {
				  System.out.println("Name of Hotel="+rs.getString(1)+"  Location of Hotel="+rs.getString(2)+" ");
			  }
			  System.out.println("While location you want to go?");
			  String loc=scanner.next();
			  String s1=null,s2=null,s3=null;
			  
			  ResultSet rs1=statement2.executeQuery("SELECT * FROM mydb.hoteldetails where location='"+loc+"' ");
		      while(rs1.next())
		      {
		    	  s1=rs1.getString(4);
		    	  s2=rs1.getString(5);
		    	  s3=rs1.getString(6);
		    	  
		    	  System.out.println("Type of rooms="+rs1.getString(4)+"."+rs1.getString(5)+","+rs1.getString(6)+" ");
		      }
		      String typeofRoom=scanner.next();
		      System.out.println("Enter the number of person?");
		      String noofperson=scanner.next();

		      ResultSet rs2=statement3.executeQuery("SELECT * FROM mydb.hoteldetails where location='"+loc+"' ");
		      System.out.println(s1);
		      while(rs2.next())
		      {
		    	  if(s1.equals(typeofRoom))
		    	  {
		    		  System.out.println("Cost of "+s1);
		    		  System.out.println("cost of room="+rs2.getFloat(13)+" for view="+rs2.getString(8));
		    		  System.out.println("cost of room="+rs2.getFloat(14)+" for view="+rs2.getString(9));
		    		  System.out.println("cost of room="+rs2.getFloat(15)+" for view="+rs2.getString(10));
		    	  } 
		    	  else if(s2.equals(typeofRoom))
		    	  {
		    		  System.out.println("Cost of "+s2);
		    		  System.out.println("cost of room="+rs2.getFloat(16)+" for view="+rs2.getString(8));
		    		  System.out.println("cost of room="+rs2.getFloat(17)+" for view="+rs2.getString(9));
		    		  System.out.println("cost of room="+rs2.getFloat(18)+" for view="+rs2.getString(10));
		    	  }
		    	  else
		    	  {
		    		  System.out.println("Cost of "+s3);
		    		  System.out.println("cost of room="+rs2.getFloat(19)+" for view="+rs2.getString(8));
		    		  System.out.println("cost of room="+rs2.getFloat(20)+" for view="+rs2.getString(9));
		    		  System.out.println("cost of room="+rs2.getFloat(21)+" for view="+rs2.getString(10));
		    	  }
		      }
		    	  
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

	}


