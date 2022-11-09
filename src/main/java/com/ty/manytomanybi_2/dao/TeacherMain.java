package com.ty.manytomanybi_2.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomanybi_2.dto.Student;
import com.ty.manytomanybi_2.dto.Teacher;

public class TeacherMain {

	public static void main(String[] args) {
		Teacher teacher1=new Teacher();
		teacher1.setId(1);
		teacher1.setName("raj");
		teacher1.setAge(42);
		teacher1.setGender("male");

		Teacher teacher2=new Teacher();
		teacher2.setId(2);
		teacher2.setName("teju");
		teacher2.setAge(52);
		teacher2.setGender("female");

		Teacher teacher3=new Teacher();
		teacher3.setId(1);
		teacher3.setName("raj");
		teacher3.setAge(42);
		teacher3.setGender("male");

		Student student1=new Student();
		student1.setId(111);
		student1.setName("belaku");
		student1.setPhone(123456);
		student1.setAddress("blr");

		Student student2=new Student();
		student2.setId(222);
		student2.setName("bhavith");
		student2.setPhone(852369);
		student2.setAddress("delhi");

		Student student3=new Student();
		student3.setId(333);
		student3.setName("ganavi");
		student3.setPhone(789456);
		student3.setAddress("pune");

		List<Student>s1=new ArrayList<Student>();
		s1.add(student1);
		s1.add(student3);
		teacher1.setStudent(s1);

		List<Student>s2=new ArrayList<Student>();
		s2.add(student2);
		s2.add(student3);
		teacher2.setStudent(s2);

		List<Student>s3=new ArrayList<Student>();
		s3.add(student1);
		s3.add(student2);
		teacher3.setStudent(s3);

		List<Teacher>t1=new ArrayList<Teacher>();
		t1.add(teacher1);
		t1.add(teacher3);
		student1.setTeacher(t1);

		List<Teacher>t2=new ArrayList<Teacher>();
		t2.add(teacher2);
		t2.add(teacher3);
		student2.setTeacher(t2);

		List<Teacher>t3=new ArrayList<Teacher>();
		t3.add(teacher1);
		t3.add(teacher2);
		student3.setTeacher(t3);

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dent");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		entityTransaction.begin();

		entityManager.persist(teacher1);
		entityManager.persist(teacher2);
		entityManager.persist(teacher3);

		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(student3);

		entityTransaction.commit();

	}

}
