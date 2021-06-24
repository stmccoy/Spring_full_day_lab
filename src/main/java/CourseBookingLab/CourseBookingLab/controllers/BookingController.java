package CourseBookingLab.CourseBookingLab.controllers;

import CourseBookingLab.CourseBookingLab.models.Booking;
import CourseBookingLab.CourseBookingLab.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(
            @RequestParam(required = false, name="date") String date
    ){
        if(date != null){
            return new ResponseEntity(bookingRepository.findByDate(StringUtils.capitalize(date)), HttpStatus.OK);
        }else{
            List<Booking> foundBookings = bookingRepository.findAll();
            return new ResponseEntity<>(foundBookings, HttpStatus.OK);
        }
    }

    @GetMapping("/bookings/{id}")
    public ResponseEntity getBookingById(@PathVariable Long id){
        Optional<Booking> foundBooking = bookingRepository.findById(id);
        return new ResponseEntity(foundBooking, HttpStatus.OK);
    }

    @PostMapping("/bookings")
    public ResponseEntity<Booking> postBooking(@RequestBody Booking booking){
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }
}
