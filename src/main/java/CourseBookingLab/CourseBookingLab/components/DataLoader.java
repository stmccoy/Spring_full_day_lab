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
        Customer customerOne = new Customer("Ben", "Edinburgh", 27);
        customerRepository.save(customerOne);

        Customer customerTwo = new Customer("Stan", "Livingston", 72);
        customerRepository.save(customerTwo);

        Course courseOne = new Course("Psychology", "Edinburgh", STAR_RATINGS.five);
        courseRepository.save(courseOne);

        Course courseTwo = new Course("Math", "Glasgow", STAR_RATINGS.zero);
        courseRepository.save(courseTwo);

        Booking bookingOne = new Booking("22/03/2020", customerOne, courseOne);
        bookingRepository.save(bookingOne);

        Booking bookingTwo = new Booking("24/03/2020", customerTwo, courseTwo);
        bookingRepository.save(bookingTwo);

    }
}
