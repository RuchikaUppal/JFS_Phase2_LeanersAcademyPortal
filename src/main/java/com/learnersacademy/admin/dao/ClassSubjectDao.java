package com.learnersacademy.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learnersacademy.admin.bean.ClassBean;
import com.learnersacademy.admin.bean.ClassSubjectBean;
import com.learnersacademy.admin.util.DBConnection;

public class ClassSubjectDao {
	
	public  List<ClassSubjectBean>  getAllSubByClassId(int classId)
	{
		List<ClassSubjectBean> listOfSubByClassId =new ArrayList<ClassSubjectBean>() ;
		
		try 
		{
			Connection con= DBConnection.getConnection();
			Statement stmt= con.createStatement();
			String query= "Select * from LA_Class_Subject where classId="+classId;
			ResultSet rs= stmt.executeQuery(query);
			
			if (rs.wasNull())
			{
				listOfSubByClassId=null;
			}
			else
			{
				while(rs.next())
				{
					ClassSubjectBean classSubBean=new ClassSubjectBean();
					
					classSubBean.setClassId(rs.getInt("classid"));
					classSubBean.setSubId(rs.getInt("subid"));
					classSubBean.setId(rs.getInt("id"));
					
					listOfSubByClassId.add(classSubBean);
				}		
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
		return listOfSubByClassId;
	}
			
	public boolean insertClassSubject(ClassSubjectBean classSubBean )
	{
		int insertCount=0;
		boolean insertStatus=false;
		try 
		{
			// before inserting check if the subject is already assigned
			Connection con= DBConnection.getConnection();
			String query= "Insert into LA_Class_Subject values (?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, classSubBean.getId());
			pstmt.setInt(2, classSubBean.getClassId());
			pstmt.setInt(3, classSubBean.getSubId());
			
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
