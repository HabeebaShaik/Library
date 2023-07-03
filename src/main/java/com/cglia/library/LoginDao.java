package com.cglia.library;

import java.sql.*;
import java.util.*;

public class LoginDao {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://192.168.60.22:3306/habeeba", "HABEEBA", "HABEEBA@12345");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	

	public static String validate(String userId, String password) {
		boolean status = false;
		String role= null;
		try {
			Connection con = LoginDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from login where userId=? and password=?");
			ps.setString(1, userId);
			ps.setString(2, password);
           
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				role=rs.getString("role");
			}
			status = rs.next();
		} catch (Exception e) {
			System.out.println(e);
		}
		return role;
	}

	public static String save(User ut) {
		String status = null;
		int stat = 0;
		try {

			Connection con = LoginDao.getConnection();
			
			int userid=Integer.parseInt(getusrid("user"));
			PreparedStatement ps = con.prepareStatement(
					"insert into user( userId,userName,age,gender,email,state,city,password) values (?,?,?,?,?,?,?,?)");
			ps.setInt(1, userid+1);
			ps.setString(2, ut.getUserName());
			ps.setInt(3, ut.getAge());
			ps.setString(4, ut.getGender());
			ps.setString(5, ut.getEmail());
			ps.setString(6, ut.getState());
			ps.setString(7, ut.getCity());
			ps.setString(8, ut.getPassword());
			stat = ps.executeUpdate();
			PreparedStatement ps1 = con.prepareStatement(
					"insert into login( userId,userName,password,role) values (?,?,?,?)");
			ps1.setInt(1, userid+1);
			ps1.setString(2, ut.getUserName());
			ps1.setString(3, ut.getPassword());
			ps1.setString(4, "customer");
			stat = ps1.executeUpdate();
			if (stat != 0) {
				status = "not saved data";
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static String getusrid(String tablename) throws SQLException {
		String userid = null;
		Connection con = LoginDao.getConnection();
				PreparedStatement ps = con.prepareStatement("select max(userId) from "+ tablename);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					userid=rs.getString(1);
				}
				return userid;
	}
	
	public static String getrole(User ut) {
		String status = null;
		int stat = 0;
		try {

			Connection con = LoginDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into user( userId,userName,age,gender,email,state,city,password) values (?,?,?,?,?,?,?,?)");
			ps.setInt(1, ut.getUserId());
			ps.setString(2, ut.getUserName());
			ps.setInt(3, ut.getAge());
			ps.setString(4, ut.getGender());
			ps.setString(5, ut.getEmail());
			ps.setString(6, ut.getState());
			ps.setString(7, ut.getCity());
			ps.setString(8, ut.getPassword());
			stat = ps.executeUpdate();
			if (stat != 0) {
				status = "not saved data";
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int save(Books book) {
		int status = 0;
		try {
			Connection con = LoginDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into books(bookId,bookName,author,year_of_publication,price,bookstatus) values (?,?,?,?,?,?)");
			ps.setInt(1, book.getBookId());
			ps.setString(2, book.getBookName());
			ps.setString(3, book.getAuthor());
			ps.setInt(4, book.getYear_of_publication());
			ps.setInt(5, book.getPrice());
			ps.setString(6, book.getBookstatus());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}
	public static String getusernamebyid(int userid) throws SQLException {
		String username= null;
		Connection con = LoginDao.getConnection();
		PreparedStatement ps = con.prepareStatement("select userName from user where userId="+userid);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			username=rs.getString(1);
		}
		return username;
	}
	
	public static String getusernameid(int userid) throws SQLException {
		String username= null;
		Connection con = LoginDao.getConnection();
		PreparedStatement ps = con.prepareStatement("select userName from login where userId="+userid);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			username=rs.getString(1);
		}
		return username;
	}
	
	public static String updatebookstatus(int userid,int bookid,String bookstatus,String bookname) throws SQLException {
		
		Connection con = LoginDao.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into bookrequest( bookid,Userid,bookstatus,bookname,Username) values (?,?,?,?,?)");
ps.setInt(1, bookid);
ps.setInt(2, userid);
ps.setString(3, bookstatus);
ps.setString(4, bookname);
ps.setString(5, getusernamebyid(userid));
ps.executeUpdate();
PreparedStatement ps1 = con.prepareStatement("update books set bookstatus='requested' where bookId="+bookid);
ps1.executeUpdate();
		return bookstatus;
		
	}
	
	public static String acceptreq(int bookid) throws SQLException {
		Connection con = LoginDao.getConnection();
		PreparedStatement ps = con.prepareStatement("update bookrequest set bookstatus='Sold' where bookId="+bookid);
		ps.executeUpdate();
		PreparedStatement ps1 = con.prepareStatement("update books set bookstatus='Sold' where bookId="+bookid);
		ps1.executeUpdate();
		return null;
	}
	
	public static List<Books> getrequestedbook() throws SQLException {
		List<Books> list = new ArrayList<Books>();
		Connection con = LoginDao.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from bookrequest where bookstatus='request' ");

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Books book = new Books();
			book.setBookId(rs.getInt(1));
			book.setUserid(rs.getInt(2));
			book.setBookName(rs.getString(4));
			book.setBookstatus(rs.getString(5));
			list.add(book);
		}
		con.close();
		return list;
		
	}
	
	public static int update(Books book) {
		int status = 0;
		try {
			Connection con = LoginDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update books set bookName=?,author=?,year_of_publication=?, price=?,bookstatus=? where bookId=? ");
			
			ps.setString(1, book.getBookName());
			ps.setString(2, book.getAuthor());
			ps.setInt(3, book.getYear_of_publication());
			ps.setInt(4, book.getPrice());
			ps.setString(5, book.getBookstatus());
			ps.setInt(6, book.getBookId());
			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static List<Books> getAllBooks() {
		List<Books> list = new ArrayList<Books>();

		try {
			Connection con = LoginDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from books");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Books book = new Books();
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setYear_of_publication(rs.getInt(4));
				book.setPrice(rs.getInt(5));
				book.setBookstatus(rs.getString(6));
				list.add(book);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public static User getUserById(int userId) {
		User user=new User();
		try {
			Connection con = LoginDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user where userId=?");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setAge(rs.getInt(3));
				user.setGender(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setState(rs.getString(6));
				user.setCity(rs.getString(7));
				user.setPassword(rs.getString(8));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return user;
	}

	public static int update(User user) {
		int status = 0;
		try {
			Connection con = LoginDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update user set userName=?, age=?, gender=?, email=?, state=?, city=?, password=? where userId=?");
			ps.setInt(1, user.getUserId());
			ps.setString(2, user.getUserName());
			ps.setInt(3,user.getAge());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getState());
			ps.setString(7, user.getCity());
			ps.setString(8, user.getPassword());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int delete(int userId) {
		 int status=0;  
	        try{  
	            Connection con=LoginDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from user where userId=?");  
	            ps.setInt(1,userId);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	}
	public static int deletebook(int userId) {
		 int status=0;  
	        try{  
	            Connection con=LoginDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from books where bookId=?");  
	            ps.setInt(1,userId);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	}

	public static List<User> getAllUsers() {
		List<User> list = new ArrayList<User>();

		try {
			Connection con = LoginDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user=new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setAge(rs.getInt(3));
				user.setGender(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setState(rs.getString(6));
				user.setCity(rs.getString(7));
				user.setPassword(rs.getString(8));
				list.add(user);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	public static List<Books> EditBooks(int id){
		List<Books> list=new ArrayList<Books>();
		Connection con = LoginDao.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from books where bookId=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Books book = new Books();
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setYear_of_publication(rs.getInt(4));
				book.setPrice(rs.getInt(5));
				book.setBookstatus(rs.getString(6));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static int getusercount(){
		
		int count = 0;
		Connection con = LoginDao.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select count(*) from user");
			ResultSet rs =	ps.executeQuery();
			if (rs.next()) {
				count=rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
		
	}
	
	public static int getreqbookcount(){
		
		int count = 0;
		Connection con = LoginDao.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select count(*) from books where bookstatus='requested' ");
			ResultSet rs =	ps.executeQuery();
			if (rs.next()) {
				count=rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
		
	}


}
