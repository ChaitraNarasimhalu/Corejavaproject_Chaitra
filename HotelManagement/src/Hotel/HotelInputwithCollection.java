package Hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HotelInputwithCollection {

	public static void main(String[] args) {
		String hotelname;
		String Location;
		int Type_of_room;
		int person;
		int viewtypes;
		int childcount;
		List<String> typeofRoom=new LinkedList();
		List<String> typeofview=new ArrayList();
		List costList=new LinkedList();
		
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your hotel name");
		hotelname=scanner.next();
		System.out.println("Enter your Location");
		Location=scanner.next();
		System.out.println("Enter your Type of rooms");
		Type_of_room=scanner.nextInt();
		String typeofRoomVar=null;
		if(Type_of_room>0)
		{
			
			for(int i=0;i<Type_of_room;i++)
			{
				System.out.println("Please enter your room type "+(i+1));
				typeofRoomVar=scanner.next();
				typeofRoom.add(typeofRoomVar);
			}
		}
		String typeofViewVar=null;
			System.out.println("How many view types you are providing ?");
			viewtypes=scanner.nextInt();
			if(viewtypes>0)
			{
				
				for(int i=0;i<viewtypes;i++)
				{
					System.out.println("Please enter your room type "+(i+1));
					typeofViewVar=scanner.next();
					typeofview.add(typeofViewVar);
				}
			}
		
			System.out.println("How many numbers of person allowed in one room? ");
			person=scanner.nextInt();
			System.out.println("How many numbers of childern allowed in one room? ");
			childcount=scanner.nextInt();
			int cost[][]=new int[Type_of_room][viewtypes];
			System.out.println("Enter your cost");
			for(int i=0;i<Type_of_room;i++)
			{
				//System.out.println("Enter cost for room "+typeofroom);
				for(int j=0;j<viewtypes;j++)
				{
					//System.out.println("Enter cost for view "+typeofView[j]);
					{
						cost[i][j]=scanner.nextInt();
						costList.add(cost[i][j]);
					}
				}
			}
			
			
	
		try 
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		Statement statement=con.createStatement();
		//String query="INSERT INTO `6625`.`hotel_input` (`name`, `location`, `types`, `room1_type`, `room2_type`, `room3_type`) VALUES ('"+hotelname+"', '"+Location+"', '"+Type_of_room+"', '"+typeofroom[0]+"', '"+typeofroom[1]+"', '"+typeofroom[2]+"');";
		//String querynew="INSERT INTO `6625`.`hotelinputwithcollection` (`name`, `location`, `types`, `typeofroom`, `view`, `viewtype`, `person`, `child`, `cost`) VALUES ('"+hotelname+"', '"+Location+"', '"+Type_of_room+"', '"+typeofRoom+"', '"+viewtypes+"','"+typeofview+"','"+person+"','"+childcount+"','"+costList+"');";
		String querynew="INSERT INTO `mydb`.`hotelinputwithcollection` (`name`, `location`, `type`, `typeofroom`, `view`, `viewtype`, `person`, `child`, `cost`) VALUES  ('"+hotelname+"', '"+Location+"', '"+Type_of_room+"', '"+typeofRoom+"', '"+viewtypes+"','"+typeofview+"','"+person+"','"+childcount+"','"+costList+"')";
				
		statement.executeUpdate(querynew);
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}


		

	}

	}


