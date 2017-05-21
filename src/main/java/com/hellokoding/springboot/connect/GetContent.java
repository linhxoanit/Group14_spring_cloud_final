package com.hellokoding.springboot.connect;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class GetContent {
	public String getNoiDung(){
		String strResult="";
		GetConnectionStr getConnectionStr=new GetConnectionStr();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con=null;
		Statement stm=null;
		ResultSet rs;	
		try
		{
			con=(Connection) DriverManager.getConnection(getConnectionStr.getSql(),getConnectionStr.getName()
					,getConnectionStr.getPass());
			stm=(Statement) con.createStatement();
			rs=stm.executeQuery("SELECT * FROM content");
			
		if(rs.next())
			strResult=rs.getString("content");
		}catch(SQLException e){
			e.printStackTrace();
		}	
		finally
		{
				try {
					con.close();
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		return strResult;
	}
	public boolean CapNhat(String noidung)
	{				
		
		GetConnectionStr s = new GetConnectionStr();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
		Connection con=null;
		Statement stm=null;
		
		try
		{
			
			con=(Connection) DriverManager.getConnection(s.getSql(),s.getName(),s.getPass());
			stm=(Statement) con.createStatement();
			String sql="UPDATE content SET content.content='"+noidung+"'";
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
			return pst.executeUpdate() > 0;						
					
		}catch(SQLException e){
			e.printStackTrace();
		}	
		finally
		{
			
				try {
					con.close();
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
		}
			
		return false;
	}
}
