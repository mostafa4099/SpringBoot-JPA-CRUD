 package com.mostafa.sna.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mostafa.sna.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Student> getAllStudents() {
		
		Query query = entityManager.createQuery("from Student", Student.class);
		
		List<Student> list = query.getResultList();
		
		return list;
	}

	@Override
	public Student getStudent(int id) {
		
		Student student = entityManager.find(Student.class, id);
		
		return student;
	}

	@Override
	public void saveOrUpdateStudent(Student student) {
		
		Student st = entityManager.merge(student);
		
//		to find generated id in insertion
		student.setId(st.getId());
		
	}

	@Override
	public void deleteStudent(Student student) {
		
			entityManager.remove(student);
			
	}

}
