package com.exam.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.exam.domain.CourseStudent;
import com.exam.service.StudentService;

@RunWith(JUnit4.class)
public class TestSource {

	@Test
	public void showCourseTest(){
		List<CourseStudent> course=StudentService.getInstance().showCourse("13104008");
		System.out.println("str="+course);
	}
}
