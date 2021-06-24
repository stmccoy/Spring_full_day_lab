package CourseBookingLab.CourseBookingLab.components;

import CourseBookingLab.CourseBookingLab.models.Booking;
import CourseBookingLab.CourseBookingLab.models.Course;
import CourseBookingLab.CourseBookingLab.models.Customer;
import CourseBookingLab.CourseBookingLab.models.STAR_RATINGS;
import CourseBookingLab.CourseBookingLab.repositories.BookingRepository;
import CourseBookingLab.CourseBookingLab.repositories.CourseRepository;
import CourseBookingLab.CourseBookingLab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        Customer customer = new Customer("Sam", "Liverpool", 27);
        customerRepository.save(customer);

        Course course = new Course("KFC Party", "All Over the Uk", STAR_RATINGS.five);
        courseRepository.save(course);

        Booking booking = new Booking("Everyday", customer, course);
        bookingRepository.save(booking);

    }
}
