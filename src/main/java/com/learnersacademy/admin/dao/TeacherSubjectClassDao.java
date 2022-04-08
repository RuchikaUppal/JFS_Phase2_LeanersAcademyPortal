package com.learnersacademy.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learnersacademy.admin.bean.ClassBean;
import com.learnersacademy.admin.bean.SubjectsBean;
import com.learnersacademy.admin.bean.TeacherBean;
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
			String query= "Insert into LA_Teacher_Subject  values (La_TeacherSubClass_seq.NEXTVAL,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, teacherSubClassBean.getTeacherId());
			pstmt.setInt(2, teacherSubClassBean.getSubId());
			pstmt.setInt(3, teacherSubClassBean.getClassId());
			
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
	
	public  List<ClassBean>  getAllClassAssignedToTeacher(int teacherId)
	{
		List<ClassBean> listOfClassAssignedToTeacher =new ArrayList<ClassBean>() ;
		
		try 
		{
			Connection con= DBConnection.getConnection();
			Statement stmt= con.createStatement();
			String query= "Select * from LA_Classes where classId in "
					+ "(Select classId from LA_Teacher_Subject  where teacherId="+teacherId+")";
			ResultSet rs= stmt.executeQuery(query);
		
			while(rs.next())
			{
				ClassBean classBean=new ClassBean();
				
				classBean.setClassId(rs.getInt("classId"));
				classBean.setClassName(rs.getString("classname"));
				classBean.setSection(rs.getString("section"));
				
				//System//.out.println("in the function"+subjectBean.getSubjectId());
				 // System.out.println("in the function"+subjectBean.getSubjectName());
				
				listOfClassAssignedToTeacher.add(classBean);
			}						
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
		return listOfClassAssignedToTeacher;
	}
	
	public  List<ClassBean>  getAllClassNotAssignedToTeacher(int teacherId)
	{
		List<ClassBean> listOfClassNotAssigedToTeacher =new ArrayList<ClassBean>() ;
		
		try 
		{
			Connection con= DBConnection.getConnection();
			Statement stmt= con.createStatement();
			String query= "Select * from LA_Classes where classId  not in "
					+ "(Select classId from LA_Teacher_Subject  where teacherId="+teacherId+")";
			ResultSet rs= stmt.executeQuery(query);
		
			while(rs.next())
			{
				ClassBean classBean=new ClassBean();
				
				classBean.setClassId(rs.getInt("classId"));
				classBean.setClassName(rs.getString("classname"));
				classBean.setSection(rs.getString("section"));
				
				//System//.out.println("in the function"+subjectBean.getSubjectId());
				 // System.out.println("in the function"+subjectBean.getSubjectName());
				
				listOfClassNotAssigedToTeacher.add(classBean);
			}						
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
		return listOfClassNotAssigedToTeacher;
	}
	
	public  List<SubjectsBean>  getAllSubAssignedToTeacher(int teacherId,int classId)
	{
		List<SubjectsBean> listOfSubAssignedToTeacher =new ArrayList<SubjectsBean>() ;
		
		try 
		{
			Connection con= DBConnection.getConnection();
			Statement stmt= con.createStatement();
			String query= "Select * from LA_Subjects inner join la_class_subject "
					+ "on la_subjects.subid=la_class_subject.subid "
					+ "where  la_class_subject.classid="+classId+" and la_subjects.subId in "
							+ "(Select subId from LA_Teacher_Subject  where teacherId="+teacherId+")";
			ResultSet rs= stmt.executeQuery(query);
		
			while(rs.next())
			{
				SubjectsBean subjectBean=new SubjectsBean();
				
				subjectBean.setSubjectId(rs.getInt("subId"));
				subjectBean.setSubjectName(rs.getString("subname"));
				
				//System//.out.println("in the function"+subjectBean.getSubjectId());
				 // System.out.println("in the function"+subjectBean.getSubjectName());
				
				listOfSubAssignedToTeacher.add(subjectBean);
			}						
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
		return listOfSubAssignedToTeacher;
	}
	
		
	public  List<SubjectsBean>  getAllSubNotAssignedToTeacher(int teacherId,int classId)
	{
		List<SubjectsBean> listOfSubNotAssignedToTeacher =new ArrayList<SubjectsBean>() ;
		
		try 
		{
			Connection con= DBConnection.getConnection();
			Statement stmt= con.createStatement();
			//String query= "Select * from LA_Subjects  where subId  not in (Select subId from LA_Teacher_Subject  where teacherId="+teacherId+" and classId= "+classId+")";
			String query= "Select * from LA_Subjects inner join la_class_subject "
					+ "on la_subjects.subid=la_class_subject.subid "
					+ "where  la_class_subject.classid="+classId+" and la_subjects.subId not in "
							+ "(Select subId from LA_Teacher_Subject  where teacherId="+teacherId+")";
			ResultSet rs= stmt.executeQuery(query);
		
			while(rs.next())
			{
				SubjectsBean subjectBean=new SubjectsBean();
				
				subjectBean.setSubjectId(rs.getInt("subId"));
				subjectBean.setSubjectName(rs.getString("subname"));
				
				//System//.out.println("in the function"+subjectBean.getSubjectId());
				 // System.out.println("in the function"+subjectBean.getSubjectName());
				
				listOfSubNotAssignedToTeacher.add(subjectBean);
			}						
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
		return listOfSubNotAssignedToTeacher;
	}
	
	public  List<TeacherBean>  getAllTeacherByClassId(int classId)
	{
		List<TeacherBean> listOfTeacherByClassId =new ArrayList<TeacherBean>() ;
		
		try 
		{
			Connection con= DBConnection.getConnection();
			Statement stmt= con.createStatement();
			String query= "Select * from LA_Teachers where teacherId in (Select teacherId from LA_Teacher_Subject  "
					+ "where classId="+classId+")";
			ResultSet rs= stmt.executeQuery(query);
		
			while(rs.next())
			{
				TeacherBean teacherBean=new TeacherBean();
				
				teacherBean.setTeacherId(rs.getInt("teacherId"));
				teacherBean.setTeacherFirstName(rs.getString("teacherfname"));
				teacherBean.setTeacherLastName(rs.getString("teacherlname"));
				
				listOfTeacherByClassId.add(teacherBean);
			}						
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
		return listOfTeacherByClassId;
	}
}
