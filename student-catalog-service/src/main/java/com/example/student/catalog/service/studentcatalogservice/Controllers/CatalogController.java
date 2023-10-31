package com.example.student.catalog.service.studentcatalogservice.Controllers;



import com.example.student.catalog.service.studentcatalogservice.Models.*;
import com.example.student.catalog.service.studentcatalogservice.Services.Interface.CatalogServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CatalogController {

    @Autowired
    private CatalogServiceInterface catalogService;

    @GetMapping("/catalogs/course/{courseCode}")
    @ResponseStatus(HttpStatus.OK)
    public Catalog getCatalog(@PathVariable Integer courseCode) {
        return catalogService.getCatalog(courseCode);
    }

}
