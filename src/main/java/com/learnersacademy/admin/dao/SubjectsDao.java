package com.learnersacademy.admin.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learnersacademy.admin.bean.SubjectsBean;
import com.learnersacademy.admin.util.DBConnection;


public class SubjectsDao {
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * SubjectsDao subDao=new SubjectsDao();
	 * List<SubjectsBean>listOfSubjects=subDao.getAllSubjects();
	 * System.out.println("size is "+listOfSubjects.size());
	 * 
	 * for (SubjectsBean subjectsBean : listOfSubjects) {
	 * System.out.println(subjectsBean.getSubjectId());
	 * System.out.println(subjectsBean.getSubjectName()); }
	 * 
	 * 
	 * SubjectsBean subBean=new SubjectsBean(); subBean.setSubjectId(10008);
	 * subBean.setSubjectName("Business Studies");
	 * 
	 * System.out.println(new SubjectsDao().updateSubjectById(subBean)); }
	 */
	
		
	public SubjectsBean getSubjectByID(int subjectId)
	{
		SubjectsBean subBean=new SubjectsBean();
		
		try 
		{
			Connection con= DBConnection.getConnection();
			Statement stmt= con.createStatement();
			String query= "Select * from LA_Subjects where SubId="+subjectId;
			ResultSet rs= stmt.executeQuery(query);
			
			if(rs.next())
			{
				subBean.setSubjectId(rs.getInt("subid"));
				subBean.setSubjectName(rs.getString("subname"));
			}
			else
			{
				subBean=null;
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return subBean;
	}
	
	public List<SubjectsBean> getAllSubjects()
	{
		List<SubjectsBean> listOfSubjects =new ArrayList<SubjectsBean>() ;
		
		try 
		{
			Connection con=DBConnection.getConnection();
			Statement stmt= con.createStatement();
			String query= "Select * from LA_Subjects order by subid";
			ResultSet rs= stmt.executeQuery(query);
						
			while(rs.next())
			{
				SubjectsBean subBean=new SubjectsBean();
				subBean.setSubjectId(rs.getInt("subid"));
				subBean.setSubjectName(rs.getString("subname"));
				listOfSubjects.add(subBean);
			}
			
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return listOfSubjects;
	}

	public boolean insertSubject(SubjectsBean subBean )
	{
		int insertCount=0;
		boolean insertStatus=false;
		try 
		{
			Connection con= DBConnection.getConnection();
			String query= "Insert into LA_Subjects values (La_subid_seq.NEXTVAL,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, subBean.getSubjectName());
			
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
	
	
	public int deleteSubjectById(int subjectId) throws SQLException
	{
		int deleteCount=0;
		try 
		{
			Connection con= DBConnection.getConnection();
			String query= "Delete LA_Subjects where subid=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, subjectId);
			
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
	
	public boolean updateSubjectById(SubjectsBean subBean)
	{
		int updateCount=0;
		boolean updateStatus=false;
		try 
		{
			Connection con= DBConnection.getConnection();
			String query= "Update LA_Subjects set subname=? where subid=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, subBean.getSubjectName());
			pstmt.setInt(2, subBean.getSubjectId());
			
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
