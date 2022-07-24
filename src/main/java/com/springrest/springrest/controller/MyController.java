package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;

@RestController
public class MyController {

    @Autowired
   private CoursesService coursesService;

    @GetMapping("/gethome")
    public String home()
    {
        return "This is home";
    }

    @GetMapping("/getCourses")
    public List<Courses> getCourses()
    {
        // return coursesService.getCourses().toString();
        return coursesService.getCourses();
    }
    @GetMapping("/getCoursesav")
    public String getCoursesav()
    {
        // return coursesService.getCourses().toString();
        return coursesService.getCoursesav();//"Test AV";
    }

    @GetMapping("/getCourses/{courseId}")
    public Courses getCourseById(@PathVariable String courseId)
    {
        // return coursesService.getCourses().toString();
        return coursesService.getCourseById(Long.parseLong(courseId));
    }

    @GetMapping("/downloadFile")
    public ResponseEntity<Resource> downloadFile() throws IOException {
        // return coursesService.getCourses().toString();
        return coursesService.AgentAgreementGeneration();
    }



}
