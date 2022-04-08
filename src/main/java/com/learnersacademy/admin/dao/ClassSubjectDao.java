package com.learnersacademy.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learnersacademy.admin.bean.ClassBean;
import com.learnersacademy.admin.bean.ClassSubjectBean;
import com.learnersacademy.admin.bean.SubjectsBean;
import com.learnersacademy.admin.util.DBConnection;

public class ClassSubjectDao {
	/*
	 * public static void main(String[] args) {
	 * 
	 * ClassSubjectDao classDao=new ClassSubjectDao();
	 * 
	 * List<SubjectsBean>listOfsub=classDao.getAllSubByClassId(10001);
	 * System.out.println("size is "+listOfsub.size());
	 * 
	 * for (SubjectsBean Bean : listOfsub) {
	 * System.out.println(Bean.getSubjectId());
	 * System.out.println(Bean.getSubjectName()); }
	 * 
	 * }
	 */
	
	public  List<SubjectsBean>  getAllSubByClassId(int classId)
	{
		List<SubjectsBean> listOfSubByClassId =new ArrayList<SubjectsBean>() ;
		
		try 
		{
			Connection con= DBConnection.getConnection();
			Statement stmt= con.createStatement();
			String query= "Select * from LA_Subjects where subId in "
					+ "(Select subid from LA_Class_Subject where classId="+classId+")";
			ResultSet rs= stmt.executeQuery(query);
		
			while(rs.next())
			{
				SubjectsBean subjectBean=new SubjectsBean();
				
				subjectBean.setSubjectId(rs.getInt("subId"));
				subjectBean.setSubjectName(rs.getString("subname"));
				
				System.out.println("in the function"+subjectBean.getSubjectId());
				  System.out.println("in the function"+subjectBean.getSubjectName());
				
				listOfSubByClassId.add(subjectBean);
			}						
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
		return listOfSubByClassId;
	}
	
	public  List<SubjectsBean>  getAllSubNotInClassId(int classId)
	{
		List<SubjectsBean> listOfSubNotInClassId =new ArrayList<SubjectsBean>() ;
		
		try 
		{
			Connection con= DBConnection.getConnection();
			Statement stmt= con.createStatement();
			String query= "Select * from LA_Subjects where subId not in "
					+ "(Select subid from LA_Class_Subject where classId="+classId+")" ;
			ResultSet rs= stmt.executeQuery(query);
			
			while(rs.next())
			{
				SubjectsBean SubjectBean=new SubjectsBean();
				
				SubjectBean.setSubjectId(rs.getInt("subId"));
				SubjectBean.setSubjectName(rs.getString("subName"));
				
				listOfSubNotInClassId.add(SubjectBean);
			}						
		
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
		return listOfSubNotInClassId;
	}
			
	public boolean insertClassSubject(ClassSubjectBean classSubBean )
	{
		int insertCount=0;
		boolean insertStatus=false;
		try 
		{
			Connection con= DBConnection.getConnection();
			String query= "Insert into LA_Class_Subject values (La_ClassSubjectId_seq.NEXTVAL,?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, classSubBean.getClassId());
			pstmt.setInt(2, classSubBean.getSubId());
			
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
}
