package com.learnersacademy.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learnersacademy.admin.bean.StudentBean;
import com.learnersacademy.admin.util.DBConnection;

public class StudentDao {
	
	 public static void main(String[] args) {
		  
			/*
			 * StudentDao Dao=new StudentDao();
			 * 
			 * Dao.getStudentByID(10003);
			 */
			
			
			/*
			 * StudentDao Dao=new StudentDao();
			 * List<StudentBean>listOfstudents=Dao.getAllStudents();
			 * System.out.println("size is "+listOfstudents.size());
			 * 
			 * for (StudentBean Bean : listOfstudents) {
			 * System.out.println(Bean.getStudentId());
			 * System.out.println(Bean.getStudentFirstName());
			 * System.out.println(Bean.getStudentLastName());
			 * System.out.println(Bean.getClassId()); }
			 */
			  
			 
			
			/*
			 * StudentBean Bean=new StudentBean();
			 * 
			 * Bean.setClassId(10008); Bean.setStudentFirstName("Akshata");
			 * Bean.setStudentLastName("Mande"); Bean.setStudentId(10011);
			 * 
			 * 
			 * System.out.println(new StudentDao().updateStudentById(Bean));
			 */
				
			/*
			 * StudentBean Bean=new StudentBean(); Bean.setStudentId(10012);
			 * Bean.setStudentFirstName("Ahmed"); Bean.setStudentLastName("Khan");
			 * Bean.setClassId(10008); System.out.println(new
			 * StudentDao().insertStudent(Bean));
			 * 
			 */
			  
			  
			  //System.out.println(new StudentDao().deleteStudentById(10012));
		 
		 }
			
		public StudentBean getStudentByID(int studentId)
		{
			StudentBean studentBean=new StudentBean();
			
			try 
			{
				Connection con= DBConnection.getConnection();
				Statement stmt= con.createStatement();
				String query= "Select * from LA_Students where stuId="+studentId;
				ResultSet rs= stmt.executeQuery(query);
				
				if(rs.next())
				{
					studentBean.setStudentId(rs.getInt("stuId"));
					studentBean.setStudentFirstName(rs.getString("stufname"));
					studentBean.setStudentLastName(rs.getString("stulname"));
					studentBean.setClassId(rs.getInt("classId"));
					
					System.out.println(rs.getInt("stuId"));
					System.out.println(rs.getString("stufname"));
					System.out.println(rs.getString("stulname"));
					System.out.println(rs.getString("classId"));
					 
				}
				else
				{
					studentBean=null;
				}
				
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			return studentBean;
		}
		
		public List<StudentBean> getAllStudents()
		{
			List<StudentBean> listOfStudents=new ArrayList<StudentBean>() ;
			
			try 
			{
				Connection con=DBConnection.getConnection();
				Statement stmt= con.createStatement();
				String query= "Select * from LA_Students";
				ResultSet rs= stmt.executeQuery(query);
							
				while(rs.next())
				{
					StudentBean studentBean=new StudentBean();
					
					studentBean.setStudentId(rs.getInt("stuId"));
					studentBean.setStudentFirstName(rs.getString("stufname"));
					studentBean.setStudentLastName(rs.getString("stulname"));
					studentBean.setClassId(rs.getInt("classId"));
					
					listOfStudents.add(studentBean);
				}			
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			return listOfStudents;
		}

		public boolean insertStudent(StudentBean studentBean )
		{
			int insertCount=0;
			boolean insertStatus=false;
			try 
			{
				Connection con= DBConnection.getConnection();
				String query= "Insert into LA_Students values (?,?,?,?)";
				PreparedStatement pstmt=con.prepareStatement(query);
				
				pstmt.setInt(1, studentBean.getStudentId());
				pstmt.setString(2, studentBean.getStudentFirstName());
				pstmt.setString(3, studentBean.getStudentLastName());
				pstmt.setInt(4, studentBean.getClassId());
				
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
		
		
		public int deleteStudentById(int studentId)
		{
			int deleteCount=0;
			try 
			{
				Connection con= DBConnection.getConnection();
				String query= "Delete LA_students where stuId=?";
				PreparedStatement pstmt=con.prepareStatement(query);
				
				pstmt.setInt(1,studentId);
				
				deleteCount= pstmt.executeUpdate();
				System.out.println("Rows impacted " +deleteCount);
						
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			return deleteCount;
		}
		
		public boolean updateStudentById(StudentBean studentBean)
		{
			int updateCount=0;
			boolean updateStatus=false;
			try 
			{
				Connection con= DBConnection.getConnection();
				String query= "Update LA_students set stufname=?,stulname=?,classid=? where stuid=?";
				
				PreparedStatement pstmt=con.prepareStatement(query);
				
				pstmt.setString(1, studentBean.getStudentFirstName());
				pstmt.setString(2, studentBean.getStudentLastName());
				pstmt.setInt(3, studentBean.getClassId());
				pstmt.setInt(4, studentBean.getStudentId());
				
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
