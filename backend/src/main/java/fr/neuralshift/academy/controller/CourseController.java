package fr.neuralshift.academy.controller;

import fr.neuralshift.academy.model.Course;
import fr.neuralshift.academy.repository.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/{id}")              // GET /api/courses/1 : une seule formation
    public Course findById(@PathVariable Long id) { // {id} de l'URL -> paramètre id
        return findOrThrow(id);
    }

    @PutMapping("/{id}")              // PUT /api/courses/1 : modifie une formation
    public Course update(@PathVariable Long id, @RequestBody Course course) {
        Course existing = findOrThrow(id);
        existing.setTitle(course.getTitle());
        existing.setDescription(course.getDescription());
        existing.setPrice(course.getPrice());
        existing.setPublished(course.isPublished());
        return courseRepository.save(existing); // id déjà présent -> UPDATE, pas INSERT
    }

    @DeleteMapping("/{id}")           // DELETE /api/courses/1 : supprime une formation
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 : réussi, rien à renvoyer
    public void delete(@PathVariable Long id) {
        courseRepository.delete(findOrThrow(id));
    }

    // findById renvoie un Optional : soit la formation, soit rien -> 404
    private Course findOrThrow(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Formation " + id + " introuvable"));
    }
}
