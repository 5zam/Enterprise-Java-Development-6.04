package com.example.student.catalog.service.studentcatalogservice.Services.Interface;

import com.example.student.catalog.service.studentcatalogservice.Models.Catalog;

public interface CatalogServiceInterface {
    Catalog getCatalog(Integer courseCode);
}
