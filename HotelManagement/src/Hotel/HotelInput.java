package Hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class HotelInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hotelname;
		  String Location;
		  int Type_of_room;
		  String view_of_room;
		  int person;
		  float room_cost;
		  int viewtypes;
		  int childcount;
		  String typeofroom[]=new String[4];
		  String typeofView[]=new String[4];
		  Scanner scanner=new Scanner(System.in);
		  System.out.println("Enter your hotel name");
		  hotelname=scanner.next();
		  System.out.println("Enter your location");
		  Location=scanner.next();
		  System.out.println("Enter your type of rooms");
		  Type_of_room=scanner.nextInt();
		  if(Type_of_room>1)
		  {
			 
			  for(int i=0;i<Type_of_room;i++)
			  {
			  System.out.println("Please enter your room type "+(i+1));
			  typeofroom[i]=scanner.next();
			  }
			  
		  }
		 
	
		  System.out.println("How many view types you are providing");
		  viewtypes=scanner.nextInt();
		  if(viewtypes>1)
		  {
			  for(int i=0;i<viewtypes;i++)
			  {
				  System.out.println("Please enter your room type "+(i+1));
				  typeofView[i]=scanner.next();
			  }
		  }
				  System.out.println("How many numbers of persons allowed in one room ?");
				  person=scanner.nextInt();
				  System.out.println("How many numbers of children allowed in one room ?");
				  childcount=scanner.nextInt();
				  int cost[][]=new int[Type_of_room][viewtypes];
				  System.out.println("Enter your cost");
				  for(int i=0;i<Type_of_room;i++)
				  {
					  System.out.println("Enter cost for room "+typeofroom[i]);
					  for(int j=0;j<viewtypes;j++)
					  {
						  System.out.println("Enter cost for view " +typeofView[j]);
						  
							  cost[i][j]=scanner.nextInt();
						  
					  }
			  }
		  
		  try
		  {
			  Class.forName("com.mysql.cj.jdbc.Driver");
	       	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			  Statement statement=con.createStatement();
			 // String querynew="INSERT INTO 'mydb'.'hotel_input' (`name` ,`location`,`types`,`room1_type`,`room2_type`,`room3_type`,`typesofView`,`view1_type`,,`view2_type`,,`view3_type`,`noofperson`,`children`,`cost11`,`cost12`,`cost13`,`cost21`,`cost22`,`cost23`,`cost31`,`cost32`,`cost33`,`childcost`) VALUES ('"+hotelname+"','"+Location+"','"+Type_of_room+"','"+typeofroom[0]+"','"+typeofroom[1]+"','"+typeofroom[2]+"','"+viewtypes+"','"+typeofView[0]+"','"+typeofView[1]+"','"+typeofView[2]+"','"+person+"','"+childcount+"','"+cost[0][0]+"','"+cost[0][1]+"','"+cost[0][2]+"','"+cost[1][0]+"','"+cost[1][1]+"','"+cost[1][2]+"','"+cost[2][0]+"','"+cost[2][1]+"','"+cost[2][2]+"')";
		     // String querynew="INSERT INTO `mydb`.`hotel_input` (`name`, `location`, `types`, `room1_type`, `room2_type`, `room3_type`, `typesofview`, `view1_type`, `view2_type`, `view3_type`, `noofperson`, `children`, `cost11`, `cost12`, `cost13`, `cost21`, `cost22`, `cost23`, `cost31`, `cost32`, `cost33`) VALUES ('"+hotelname+"','"+Location+"','"+Type_of_room+"','"+typeofroom[0]+"','"+typeofroom[1]+"','"+typeofroom[2]+"','"+viewtypes+"','"+typeofView[0]+"','"+typeofView[1]+"','"+typeofView[2]+"','"+person+"','"+childcount+"','"+cost[0][0]+"','"+cost[0][1]+"','"+cost[0][2]+"','"+cost[1][0]+"','"+cost[1][1]+"','"+cost[1][2]+"','"+cost[2][0]+"','"+cost[2][1]+"','"+cost[2][2]+"')";
			  String querynew="INSERT INTO `mydb`.`hoteldetails` (`name`, `location`, `types`, `room1_type`, `room2_type`, `room3_type`, `typesofview`, `view1_type`, `view2_type`, `view3_type`, `noofperson`, `children`, `price11`, `price12`, `price13`, `price21`, `price22`, `price23`, `price31`, `price32`, `price33`) VALUES ('"+hotelname+"','"+Location+"','"+Type_of_room+"','"+typeofroom[0]+"','"+typeofroom[1]+"','"+typeofroom[2]+"','"+viewtypes+"','"+typeofView[0]+"','"+typeofView[1]+"','"+typeofView[2]+"','"+person+"','"+childcount+"','"+cost[0][0]+"','"+cost[0][1]+"','"+cost[0][2]+"','"+cost[1][0]+"','"+cost[1][1]+"','"+cost[1][2]+"','"+cost[2][0]+"','"+cost[2][1]+"','"+cost[2][2]+"')";
			  statement.executeUpdate(querynew);
			  System.out.println("Added sucesfully");
		  }
		  catch(Exception e)
		  {
			  System.out.println(e);
		  
		  }
	  }



	}

