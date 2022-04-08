package com.learnersacademy.admin.service;

import java.sql.SQLException;
import java.util.List;

import com.learnersacademy.admin.bean.ClassBean;
import com.learnersacademy.admin.bean.ClassSubjectBean;
import com.learnersacademy.admin.bean.StudentBean;
import com.learnersacademy.admin.bean.SubjectsBean;
import com.learnersacademy.admin.bean.TeacherBean;
import com.learnersacademy.admin.bean.TeacherSubjectClassBean;
import com.learnersacademy.admin.bean.UserBean;
import com.learnersacademy.admin.dao.ClassDao;
import com.learnersacademy.admin.dao.ClassSubjectDao;
import com.learnersacademy.admin.dao.StudentDao;
import com.learnersacademy.admin.dao.SubjectsDao;
import com.learnersacademy.admin.dao.TeacherDao;
import com.learnersacademy.admin.dao.TeacherSubjectClassDao;
import com.learnersacademy.admin.dao.UserDao;

public class AdminService {
	
	/*
	 * public static void main(String[] args) { AdminService service=new
	 * AdminService();
	 * 
	 * //classDao.getClassByID(10008);
	 * 
	 * 
	 * List<ClassBean>listOfClasses=service.viewClasses();
	 * System.out.println("size of the class list "+listOfClasses.size());
	 * 
	 * for (ClassBean classBean : listOfClasses) {
	 * System.out.println(classBean.getClassId());
	 * System.out.println(classBean.getClassName()); }
	 * 
	 * }
	 */
	
	SubjectsDao subjectDao=new SubjectsDao();
	StudentDao studentDao=new StudentDao();
	TeacherDao teacherDao=new TeacherDao();
	ClassDao classDao=new ClassDao();
	ClassSubjectDao classSubjectDao=new ClassSubjectDao();
	TeacherSubjectClassDao teacherSubjectClassDao=new TeacherSubjectClassDao();
	
	public boolean saveSubject(SubjectsBean bean)
	{
		return subjectDao.insertSubject(bean);
	}
	
	public int deleteSubject(int subjectId)throws SQLException
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
	
	public int deleteClass(int classId) throws SQLException
	{
		return classDao.deleteClassById(classId);
	}
	
	public List<ClassBean>  viewClasses()
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
	
	public int deleteTeacher(int teacherId)throws SQLException
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
	
	public int deleteStudent(int studentId) throws SQLException
	{
		return studentDao.deleteStudentById(studentId);
	}
	
	public List<StudentBean> viewStudents()
	{
		return studentDao.getAllStudents();
	}
	
	public List<StudentBean> viewStudentsByClassId(int classId)
	{
		return studentDao.getAllStudentsByClassId(classId);
	}
	
	
	public boolean updateStudent(StudentBean bean)
	{
		return studentDao.updateStudentById(bean);
	}
	
	public StudentBean viewStudentById(int studentId)
	{
		return studentDao.getStudentByID(studentId);
	}
	
	
	public List<SubjectsBean> viewSubjectsNotInClass(int classId)
	{
		
		List<SubjectsBean>listOfSubNotInClassId=classSubjectDao.getAllSubNotInClassId(classId);
		return listOfSubNotInClassId;
		
	}
	
	public List<SubjectsBean> viewSubjectsInClass(int classId)
	{
		
		List<SubjectsBean>listOfSubInClassId=classSubjectDao.getAllSubByClassId(classId);
		return listOfSubInClassId;
		
	}
	
	public boolean saveClassSubject(ClassSubjectBean bean)
	{
		return classSubjectDao.insertClassSubject(bean);
	}
	
	public List<ClassBean> viewClassesAssigendToTeacher(int teacherID)
	{
		
		List<ClassBean>listOfClassAssignedToTeacher=teacherSubjectClassDao.getAllClassAssignedToTeacher(teacherID);
		return listOfClassAssignedToTeacher;
		
	}
	
	public List<ClassBean> viewClassesNotAssigendToTeacher(int teacherID)
	{
		
		List<ClassBean>listOfClassNotAssignedToTeacher=teacherSubjectClassDao.getAllClassNotAssignedToTeacher(teacherID);
		return listOfClassNotAssignedToTeacher;
		
	}
	
	public boolean saveTeacherClassSubject(TeacherSubjectClassBean bean)
	{
		return teacherSubjectClassDao.insertTeacherSubjectClass(bean);
	}
	
	public List<SubjectsBean> viewSubjectsNotAssignedToTeacher(int classId,int teacherId)
	{
		
		List<SubjectsBean>listOfSubNotAssigned=teacherSubjectClassDao.getAllSubNotAssignedToTeacher(teacherId, classId);
		return listOfSubNotAssigned;
		
	}
	
	public List<SubjectsBean> viewSubjectsAssignedToTeacher(int classId, int teacherId)
	{
		
		List<SubjectsBean>listOfSubAssigned=teacherSubjectClassDao.getAllSubAssignedToTeacher(teacherId, classId);
		return listOfSubAssigned;
		
	}
	
	public List<TeacherBean> viewAllTeachersByClassId(int classId)
	{
		
		List<TeacherBean>listOfTeachersByClassId=teacherSubjectClassDao.getAllTeacherByClassId(classId);
		return listOfTeachersByClassId;
		
	}
	
}
