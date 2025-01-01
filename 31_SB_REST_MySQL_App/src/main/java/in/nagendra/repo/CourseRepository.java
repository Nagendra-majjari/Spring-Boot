package in.nagendra.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nagendra.binding.Course;

public interface CourseRepository extends JpaRepository<Course,Serializable>{

}
