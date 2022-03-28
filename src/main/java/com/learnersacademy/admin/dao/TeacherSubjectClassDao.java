package com.learnersacademy.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.learnersacademy.admin.bean.TeacherSubjectClassBean;
import com.learnersacademy.admin.util.DBConnection;

public class TeacherSubjectClassDao {
	public boolean insertTeacherSubjectClass(TeacherSubjectClassBean teacherSubClassBean )
	{
		int insertCount=0;
		boolean insertStatus=false;
		try 
		{
			Connection con= DBConnection.getConnection();
			String query= "Insert into LA_Teacher_Subject  values (?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, teacherSubClassBean.getId());
			pstmt.setInt(2, teacherSubClassBean.getTeacherId());
			pstmt.setInt(3, teacherSubClassBean.getSubId());
			pstmt.setInt(4, teacherSubClassBean.getClassId());
			
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
