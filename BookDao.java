package com.my_shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class BookDao {
	static Connection con= CP.createc();
	static int stock;
	static PreparedStatement ps;
	static ResultSet rs;
	static boolean f=false;
	static Statement st;
	static Scanner scan=new Scanner(System.in);
	public static boolean insert(Book b) {
		
		String q="insert into book(name,author,price,publisher,stock) values(?,?,?,?,?)";
		f=false;
		try {
			//prepared statement
			ps=con.prepareStatement(q);
			//set the value of parameter
			ps.setString(1, b.getName());
			ps.setString(2, b.getAuthor());
			ps.setFloat(3, b.getPrice());
			ps.setString(4, b.getPublisher());
			ps.setInt(5, b.getStock());
			
			//execute
			ps.executeUpdate();
			f=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
		
	}
	
	public static boolean delete(String name,String author) {
		f=false;
		String q="DELETE FROM book WHERE name=? AND author=?";
		String q1="select * from book where name='"+name+"' AND author='"+author+"'";
		//prepared statement
		try {
			ps=con.prepareStatement(q1);
			rs=ps.executeQuery(q1);
			f=rs.isBeforeFirst();
			if(f) {
				ps=con.prepareStatement(q);
				ps.setString(1, name);
				ps.setString(2, author);
				ps.executeUpdate();
			return f;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		 
		}
		return f;
		
	}
	static int i=0;
	public static boolean updateStock(String name,String author) {
		f=false;
		String q="select * from book where name='"+name+"' AND author='"+author+"'";		
		try {
			ps=con.prepareStatement(q);
			rs=ps.executeQuery(q);
			f=rs.isBeforeFirst();
			if(f) {
				st=con.createStatement();
				System.out.println("Enter the Stock Number");
				int stock=scan.nextInt();
				while(rs.next()) {
					 i=Integer.parseInt(rs.getString(5));
						}
				stock=stock+i;
			    st.executeUpdate("UPDATE book SET stock='"+stock+"'WHERE  name='"+name+"' AND author='"+author+"'");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public static boolean checkBook(String name,String author) {
		String q="select * from book where name='"+name+"' AND author='"+author+"'";
		try {
			ps = con.prepareStatement(q);
			rs=ps.executeQuery(q);
			f=rs.isBeforeFirst();
			if(f) {
				System.out.println("Book is Available in Stock....\n");
				while(rs.next()) {
					System.out.println("Name of Book is '"+rs.getString(1)+"'");
					System.out.println("Author name is '"+rs.getString(2)+"'");
					System.out.println("Price of Book is "+rs.getString(3));
					System.out.println("Publisher of Book is '"+rs.getString(4)+"'");
					System.out.println(rs.getString(5)+" Book present in Stock \n ");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public static boolean saleBook(String name,String author) {
		String q="select * from book where name='"+name+"' AND author='"+author+"'";
		float j=0,price,discount;
		int	k=0;
		try {
			ps=con.prepareStatement(q);
			rs=ps.executeQuery();
			f=rs.isBeforeFirst();
			if(f) {
				System.out.println("Book is Available in Stock.....\n");
				while(rs.next()) {
					System.out.println("Name of Book is '"+rs.getString(1)+"'");
					System.out.println("Author name is '"+rs.getString(2)+"'");
					System.out.println("Price of Book is "+rs.getString(3));
					j=Float.parseFloat(rs.getString(3));
					System.out.println("Publisher of Book is '"+rs.getString(4)+"'");
					System.out.println(rs.getString(5)+" Book present in Stock \n");
					k=Integer.parseInt(rs.getString(5));
				}
				System.out.println("Please Enter a number you want book ");
				i=scan.nextInt();
				price=j*i;
				System.out.println("Total Price of Book is "+price+"\n");
				k=k-i;
				discount=20/j*100;
				discount=discount*i;
				discount=price-discount;
				System.out.println("After applied 20% Discount the cost is "+discount+"\n ");
				st=con.createStatement();
				st.executeUpdate("UPDATE book SET stock='"+k+"'WHERE  name='"+name+"' AND author='"+author+"'");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}
	

}
