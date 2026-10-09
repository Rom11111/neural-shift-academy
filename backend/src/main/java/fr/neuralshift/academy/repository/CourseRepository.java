package fr.neuralshift.academy.repository;

import fr.neuralshift.academy.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
