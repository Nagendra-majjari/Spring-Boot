package in.nagendra.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nagendra.binding.Course;
import in.nagendra.repo.CourseRepository;
import in.nagendra.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepo;

	@Override
	public String upsert(Course course) {

		Course save = courseRepo.save(course);// upsert (Insert + Update)

		return "Success";
	}

	@Override
	public Course getById(Integer cid) {
		Optional<Course> byId = courseRepo.findById(cid);

		if (byId.isPresent()) {
			return byId.get();
		}
		return null;
	}

	@Override
	public List<Course> getAllCourses() {

		List<Course> all = courseRepo.findAll();

		return all;
	}

	@Override
	public String deleteById(Integer cid) {

		if (courseRepo.existsById(cid)) {
			courseRepo.deleteById(cid);
			return "Delete Success";
		} else {
			return "No Record Found";
		}

	}

}
