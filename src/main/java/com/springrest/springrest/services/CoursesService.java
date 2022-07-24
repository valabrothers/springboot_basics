package com.springrest.springrest.services;

import com.springrest.springrest.entities.Courses;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


public interface CoursesService {

    public List<Courses> getCourses();
    public Courses getCourseById(Long courseId);

    public String getCoursesav();

        public ResponseEntity<Resource> AgentAgreementGeneration() throws IOException;

}
