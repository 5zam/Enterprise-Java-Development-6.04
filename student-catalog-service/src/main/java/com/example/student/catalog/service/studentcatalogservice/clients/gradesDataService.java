package com.example.student.catalog.service.studentcatalogservice.clients;


import com.example.student.catalog.service.studentcatalogservice.Models.Course;
import com.example.student.catalog.service.studentcatalogservice.Models.CourseGrade;
import com.example.student.catalog.service.studentcatalogservice.Models.Grade;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@FeignClient("GRADE-DATA-SERVICE")
public interface gradesDataService {

    @GetMapping("/grades")
    List<Grade> getGrades(@RequestParam Optional<Long> id);

    @GetMapping("/course/{courseCode}/grades")
    CourseGrade getCourseGrades(@PathVariable Integer courseCode);

    @GetMapping("/courses/{courseCode}")
    Course getCourseById(@PathVariable Integer courseCode);
}
