package com.example.student.catalog.service.studentcatalogservice.Services.Implem;


import com.example.student.catalog.service.studentcatalogservice.Models.*;
import com.example.student.catalog.service.studentcatalogservice.Services.Interface.CatalogServiceInterface;
import com.example.student.catalog.service.studentcatalogservice.clients.StudentInfoService;
import com.example.student.catalog.service.studentcatalogservice.clients.gradesDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.student.catalog.service.studentcatalogservice.Models.Grade;

@Service
@Slf4j
public class CatalogService implements CatalogServiceInterface {

    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private gradesDataService gradesDataService1;

    @Override
    public Catalog getCatalog(Integer courseCode) {
        //course and CourseGrade -> gradesDataService1
        Course course = gradesDataService1.getCourseById(courseCode);
        CourseGrade courseGrades = gradesDataService1.getCourseGrades(courseCode);

        //Student -> studentInfoService
        String port = studentInfoService.getStudentInfo();
        log.info("Student Service Running in port - " + port);

        //catalog -> new Catalog set & get course name
        Catalog catalog = new Catalog();
        catalog.setCourseName(course.getCourseName());
        List<StudentGrade> studentsGrades = new ArrayList<>();

        //Loop over all course grades and get the student information for each grade
        for (Grade grade : courseGrades.getGrades()) {
            Student student = studentInfoService.getStudentInfo(grade.getStudent_id());
            studentsGrades.add(new StudentGrade(student.getStudent_name(), student.getStudent_Age(), grade.getGrade()));
        }

        catalog.setStudentGrades(studentsGrades);
        return catalog;
    }
}
