package com.learnersacademy.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learnersacademy.admin.bean.TeacherBean;
import com.learnersacademy.admin.util.DBConnection;

public class TeacherDao {
	 public static void main(String[] args) {
		  
		 // TeacherDao Dao=new TeacherDao();
		 
		 // Dao.getTeacherByID(10003);
			
			
			/*
			 * List<TeacherBean>listOfTeachers=Dao.getAllTeachers();
			 * System.out.println("size is "+listOfTeachers.size());
			 * 
			 * for (TeacherBean teacherBean : listOfTeachers) {
			 * System.out.println(teacherBean.getTeacherId());
			 * System.out.println(teacherBean.getTeacherFirstName());
			 * System.out.println(teacherBean.getTeacherLastName()); }
			 * 
			 */
			/*
			 * 
			 * TeacherBean teacherBean=new TeacherBean();
			 * 
			 * teacherBean.setTeacherId(10003); teacherBean.setTeacherFirstName("Mary");
			 * teacherBean.setTeacherLastName("Joseph");
			 * 
			 * 
			 * System.out.println(new TeacherDao().updateTeacherById(teacherBean));
			 */
			/*
			 * TeacherBean teacherBean=new TeacherBean(); teacherBean.setTeacherId(10004);
			 * teacherBean.setTeacherFirstName("Manmohan");
			 * teacherBean.setTeacherLastName("Singh"); System.out.println(new
			 * TeacherDao().insertTeacher(teacherBean));
			 */
			  
			  
			  //System.out.println(new TeacherDao().deleteTeacherById(10004));
		 
		 }
			
		public TeacherBean getTeacherByID(int teacherId)
		{
			TeacherBean teacherBean=new TeacherBean();
			
			try 
			{
				Connection con= DBConnection.getConnection();
				Statement stmt= con.createStatement();
				String query= "Select * from LA_teachers where teacherId="+teacherId;
				ResultSet rs= stmt.executeQuery(query);
				
				if(rs.next())
				{
					teacherBean.setTeacherId(rs.getInt("teacherId"));
					teacherBean.setTeacherFirstName(rs.getString("teacherfname"));
					teacherBean.setTeacherLastName(rs.getString("teacherlname"));
					
					  //System.out.println(rs.getInt("teacherId"));
					 // System.out.println(rs.getString("teacherfname"));
					  //System.out.println(rs.getString("teacherlname"));
					 
				}
				else
				{
					teacherBean=null;
				}
				
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			return teacherBean;
		}
		
		public List<TeacherBean> getAllTeachers()
		{
			List<TeacherBean> listOfTeachers =new ArrayList<TeacherBean>() ;
			
			try 
			{
				Connection con=DBConnection.getConnection();
				Statement stmt= con.createStatement();
				String query= "Select * from LA_Teachers order by teacherId";
				ResultSet rs= stmt.executeQuery(query);
							
				while(rs.next())
				{
					TeacherBean teacherBean=new TeacherBean();
					
					teacherBean.setTeacherId(rs.getInt("teacherId"));
					teacherBean.setTeacherFirstName(rs.getString("teacherfname"));
					teacherBean.setTeacherLastName(rs.getString("teacherlname"));
					
					listOfTeachers.add(teacherBean);
				}			
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			return listOfTeachers;
		}

		public boolean insertTeacher(TeacherBean teacherBean )
		{
			int insertCount=0;
			boolean insertStatus=false;
			try 
			{
				Connection con= DBConnection.getConnection();
				String query= "Insert into LA_Teachers values (La_teacherId_seq.NEXTVAL,?,?)";
				PreparedStatement pstmt=con.prepareStatement(query);
				
				pstmt.setString(1, teacherBean.getTeacherFirstName());
				pstmt.setString(2, teacherBean.getTeacherLastName());
				
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
		
		
		public int deleteTeacherById(int teacherId)throws SQLException
		{
			int deleteCount=0;
			try 
			{
				Connection con= DBConnection.getConnection();
				String query= "Delete LA_Teachers where teacherId=?";
				PreparedStatement pstmt=con.prepareStatement(query);
				
				pstmt.setInt(1,teacherId);
				
				deleteCount= pstmt.executeUpdate();
				System.out.println("Rows impacted " +deleteCount);
						
			}
			catch(SQLException e)
			{
				 String errMsg = e.getMessage();
				 throw new SQLException ("ErrorMes", errMsg);
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			return deleteCount;
		}
		
		public boolean updateTeacherById(TeacherBean teacherBean)
		{
			int updateCount=0;
			boolean updateStatus=false;
			try 
			{
				Connection con= DBConnection.getConnection();
				String query= "Update LA_Teachers set teacherfname=?,teacherlname=? where teacherid=?";
				
				PreparedStatement pstmt=con.prepareStatement(query);
				
				pstmt.setString(1, teacherBean.getTeacherFirstName());
				pstmt.setString(2, teacherBean.getTeacherLastName());
				pstmt.setInt(3, teacherBean.getTeacherId());
				
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
