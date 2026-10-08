package fr.neuralshift.academy.controller;

import fr.neuralshift.academy.model.Course;
import fr.neuralshift.academy.repository.CourseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository; // Spring fournit le repository
    }

    @GetMapping                       // GET /api/courses : liste tout
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @PostMapping                      // POST /api/courses : crée une formation
    public Course create(@RequestBody Course course) { // JSON reçu -> objet Course
        return courseRepository.save(course);
    }
}
