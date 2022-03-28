package com.learnersacademy.admin.service;

import java.util.List;

import com.learnersacademy.admin.bean.ClassBean;
import com.learnersacademy.admin.bean.ClassSubjectBean;
import com.learnersacademy.admin.bean.StudentBean;
import com.learnersacademy.admin.bean.SubjectsBean;
import com.learnersacademy.admin.bean.TeacherBean;
import com.learnersacademy.admin.bean.UserBean;
import com.learnersacademy.admin.dao.ClassDao;
import com.learnersacademy.admin.dao.ClassSubjectDao;
import com.learnersacademy.admin.dao.StudentDao;
import com.learnersacademy.admin.dao.SubjectsDao;
import com.learnersacademy.admin.dao.TeacherDao;
import com.learnersacademy.admin.dao.UserDao;

public class AdminService {
	
	SubjectsDao subjectDao=new SubjectsDao();
	StudentDao studentDao=new StudentDao();
	TeacherDao teacherDao=new TeacherDao();
	ClassDao classDao=new ClassDao();
	
	public boolean saveSubject(SubjectsBean bean)
	{
		return subjectDao.insertSubject(bean);
	}
	
	public int deleteSubject(int subjectId)
	{
		return subjectDao.deleteSubjectById(subjectId);
	}
	
	public List<SubjectsBean> viewSubjects()
	{
		return subjectDao.getAllSubjects();
	}
	
	public boolean updateSubject(SubjectsBean bean)
	{
		return subjectDao.updateSubjectById(bean);
	}
	
	public SubjectsBean viewSubjectById(int subjectId)
	{
		return subjectDao.getSubjectByID(subjectId);
	}
	
	public boolean saveClass(ClassBean bean)
	{
		return classDao.insertClass(bean);
	}
	
	public int deleteClass(int classId)
	{
		return classDao.deleteClassById(classId);
	}
	
	public List<ClassBean>  viewClasses(ClassBean bean)
	{
		return classDao.getAllClasses();
	}
	
	public boolean updateClass(ClassBean bean)
	{
		return	classDao.updateClassById(bean);
	}
	
	public ClassBean viewClasseById(int classId)
	{
		return classDao.getClassByID(classId);
	}

	public boolean saveTeacher(TeacherBean bean)
	{
		return teacherDao.insertTeacher(bean);
	}
	
	public int deleteTeacher(int teacherId)
	{
		return teacherDao.deleteTeacherById(teacherId);
	}
	
	public List<TeacherBean> viewTeachers()
	{
		return teacherDao.getAllTeachers();
	}
	
	public boolean updateTeacher(TeacherBean bean)
	{
		return teacherDao.updateTeacherById(bean);
	}
	
	public TeacherBean viewTeacherById(int teacherId)
	{
		return teacherDao.getTeacherByID(teacherId);
	}
	
	public boolean saveStudent(StudentBean bean)
	{
		return studentDao.insertStudent(bean);
	}
	
	public int deleteStudent(int studentId)
	{
		return studentDao.deleteStudentById(studentId);
	}
	
	public List<StudentBean> viewStudents()
	{
		return studentDao.getAllStudents();
	}
	
	public boolean updateStudent(StudentBean bean)
	{
		return studentDao.updateStudentById(bean);
	}
	
	public StudentBean viewStudentById(int studentId)
	{
		return studentDao.getStudentByID(studentId);
	}
	
	
	public void assignSubjectsToClasses()
	{
		// before inserting check if the subject is already assigned to the class
		ClassSubjectDao userDao=new ClassSubjectDao();
	
	    
	    
		
		  List<ClassSubjectBean>listOfSubByClassId=userDao.getAllSubByClassId(0);
		  
		  if (listOfSubByClassId==null)
		  {
			  //insert the sub for the claa
		  }
			  
		  else
		  {
			  for (ClassSubjectBean classSubBean : listOfSubByClassId) 
			  {
				//take class id from userbean...check which subjects are already assined from db bean
					
				  
			  }
		  }
		  
		
		
	}
	
	public void assignTeacherToClassesAndSubjects()
	{
		// before inserting check if the subject and the class  is already assigned to the teacher 
	}
	
}
