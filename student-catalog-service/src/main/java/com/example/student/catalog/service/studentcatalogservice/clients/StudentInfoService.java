package com.example.student.catalog.service.studentcatalogservice.clients;


import com.example.student.catalog.service.studentcatalogservice.Models.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("STUDENT-INFO-SERVICE")
public interface StudentInfoService {

    @GetMapping("/students/{Student_id}")
    Student getStudentInfo(@PathVariable Integer Student_id);


    //testing
    @GetMapping("/students/test")
    String getStudentInfo();
}
