package test_sql_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   
		
		//int i=insert(new Customer(7,"student","yejiajia","fm",1994));
		//int j=update(new Customer(5,"4323","yejia","male",1994));
		int i=insert(new Customer("43238789034","fufu","female",1990));
		int j=update(1993,"female");
		String identity=select("fufu");	  
		int h=delete(1994);	  
		System.out.println(i);
		System.out.println(j);
		System.out.println(identity);
        System.out.println(h);
        return;
	}
	
	 public static Connection connect()
	 {
		 String driver = "com.mysql.jdbc.Driver";
		    String url = "jdbc:mysql://localhost:3306/hotel";
		    String username = "root";
		    String password = "liuyejia";
		    Connection conn = null;
		    try {
		        Class.forName(driver); //classLoader,加载对应驱动
		        conn = (Connection) DriverManager.getConnection(url, username, password);
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return conn;
	 }
	
	 //insert operation
	 public static int insert(Customer cus)
	 {
		 Connection conn=connect();
		 int i=0;
		 String sql="insert into customer(identity,name,gender,birthyear) values(?,?,?,?)";
		 try{
		 PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
		
		 ps.setString(1, cus.getIdentity());
		 ps.setString(2, cus.getName());
		 ps.setString(3, cus.getGender());
		 ps.setInt(4, cus.getBirthYear());
		 i=ps.executeUpdate();
		 ps.close();
		 conn.close();
		 }catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 return i;
	 }

	 //update
	 public static int update(int bY,String gender)
	 {
		 Connection conn = connect();
		    int i = 0;
		    String sql = "update customer set gender='" + gender + "' where birthyear='" + bY+"'";
		    PreparedStatement pstmt;
		    try {
		        pstmt = (PreparedStatement) conn.prepareStatement(sql);
		        i = pstmt.executeUpdate();
		      
		        pstmt.close();
		        conn.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return i;
	 }
	
	 //select
	 public static String select(String name)
	 {
		 Customer cus=new Customer("","","",0);
		 Connection conn = connect();
		    String sql = "select identity from customer where name='"+ name + "'";
		    PreparedStatement pstmt;
		    String identity=null;
		    try {
		        pstmt = (PreparedStatement)conn.prepareStatement(sql);
		        ResultSet rs = pstmt.executeQuery();
		        while(rs.next())
		        {
		        	identity=rs.getString("identity");
		        	
		        }
		          
		        }
		         catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return identity;
	 }
     
	 //delete
	 public static int delete(int bY)
	 {
		 Connection conn = connect();
		    int i = 0;
		    String sql = "delete from customer where birthyear=" + bY + "";
		    PreparedStatement pstmt;
		    try {
		        pstmt = (PreparedStatement) conn.prepareStatement(sql);
		        i = pstmt.executeUpdate();
		      
		        pstmt.close();
		        conn.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return i;
	 }
    
	 
}
