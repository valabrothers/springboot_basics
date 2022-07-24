package com.springrest.springrest.services;

import com.springrest.springrest.entities.Courses;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CoursesService {

    List <Courses>list;

    public CourseServiceImpl() {
      list=new ArrayList<>();
      list.add(new Courses(1,"SpringBoot","SpringBootCourse"));
      list.add(new Courses(2,"AWS","AWSCourse"));
    }

    @Override
    public List<Courses> getCourses() {
        return list;
    }


    @Override
    public String getCoursesav(){
        return "Override Test AV";

    }

    @Override
    public Courses getCourseById(Long courseId) {
        Courses c=null;
        for(Courses course :list)
        {
            if(course.getId()==courseId)
            {
                c=course;
                break;
            }
        }
        return c;
    }


    public ResponseEntity<Resource> AgentAgreementGeneration() throws IOException {


        //File file = new File("C:/Dummy/dummy.txt");
        String filename="C:\\projects\\springrest\\springrest\\src\\main\\resources\\dummy.txt";
        Path path = Paths.get(filename);

        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=dummy.txt");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

       // Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok()
                .headers(header)
              //  .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);

    }


}
