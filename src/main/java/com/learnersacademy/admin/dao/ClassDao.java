package com.learnersacademy.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learnersacademy.admin.bean.ClassBean;
import com.learnersacademy.admin.util.DBConnection;

public class ClassDao {
	
	  public static void main(String[] args) {
	  
	  //ClassDao classDao=new ClassDao();
	 
	  //classDao.getClassByID(10008);
		
		/*
		 * List<ClassBean>listOfClasses=classDao.getAllClasses();
		 * System.out.println("size is "+listOfClasses.size());
		 * 
		 * for (ClassBean classBean : listOfClasses) {
		 * System.out.println(classBean.getClassId());
		 * System.out.println(classBean.getClassName()); }
		 */
	  
	  
		/*
		 * ClassBean classBean=new ClassBean(); classBean.setClassId(10008);
		 * classBean.setClassName("12 Com B");
		 * 
		 * System.out.println(new ClassDao().updateClassById(classBean));
		 */
	  
		 // ClassBean classBean=new ClassBean();
		  //classBean.setClassId(10009);
		  //classBean.setClassName("12 Com C");
		  //System.out.println(new ClassDao().insertClass(classBean));
		  
		  
		  //System.out.println(new ClassDao().deleteClassById(10009));
	 
	 }
		
	public ClassBean getClassByID(int classId)
	{
		ClassBean classBean=new ClassBean();
		
		try 
		{
			Connection con= DBConnection.getConnection();
			Statement stmt= con.createStatement();
			String query= "Select * from LA_Classes where classId="+classId;
			ResultSet rs= stmt.executeQuery(query);
			
			if(rs.next())
			{
				classBean.setClassId(rs.getInt("classId"));
				classBean.setClassName(rs.getString("classname"));
				
				/*
				 * System.out.println(rs.getInt("classId"));
				 * System.out.println(rs.getString("classname"));
				 */
			}
			else
			{
				classBean=null;
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return classBean;
	}
	
	public List<ClassBean> getAllClasses()
	{
		List<ClassBean> listOfClasses =new ArrayList<ClassBean>() ;
		
		try 
		{
			Connection con=DBConnection.getConnection();
			Statement stmt= con.createStatement();
			String query= "Select * from LA_Classes";
			ResultSet rs= stmt.executeQuery(query);
						
			while(rs.next())
			{
				ClassBean classBean=new ClassBean();
				classBean.setClassId(rs.getInt("classid"));
				classBean.setClassName(rs.getString("classname"));
				listOfClasses.add(classBean);
			}			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return listOfClasses;
	}

	public boolean insertClass(ClassBean classBean )
	{
		int insertCount=0;
		boolean insertStatus=false;
		try 
		{
			Connection con= DBConnection.getConnection();
			String query= "Insert into LA_Classes values (?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, classBean.getClassId());
			pstmt.setString(2, classBean.getClassName());
			
			insertCount= pstmt.executeUpdate();
			
			if (insertCount>0)
			{
				System.out.println("Rows impacted " +insertCount);
				insertStatus=true;
			}
					
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return insertStatus;
	}
	
	
	public int deleteClassById(int classId)
	{
		int deleteCount=0;
		try 
		{
			Connection con= DBConnection.getConnection();
			String query= "Delete LA_Classes where classId=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1,classId);
			
			deleteCount= pstmt.executeUpdate();
			System.out.println("Rows impacted " +deleteCount);
					
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return deleteCount;
	}
	
	public boolean updateClassById(ClassBean classBean)
	{
		int updateCount=0;
		boolean updateStatus=false;
		try 
		{
			Connection con= DBConnection.getConnection();
			String query= "Update LA_Classes set Classname=? where classid=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, classBean.getClassName());
			pstmt.setInt(2, classBean.getClassId());
			
			updateCount= pstmt.executeUpdate();
			
			if (updateCount>0)
			{
				System.out.println("Rows impacted " +updateCount);
				updateStatus=true;
			}
					
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return updateStatus;
	}

}
