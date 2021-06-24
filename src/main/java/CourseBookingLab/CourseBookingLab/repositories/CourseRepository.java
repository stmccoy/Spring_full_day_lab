package CourseBookingLab.CourseBookingLab.repositories;

import CourseBookingLab.CourseBookingLab.models.Course;
import CourseBookingLab.CourseBookingLab.models.STAR_RATINGS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByRating(STAR_RATINGS rating);

    List<Course> findByBookingsCustomerName(String name);
}
