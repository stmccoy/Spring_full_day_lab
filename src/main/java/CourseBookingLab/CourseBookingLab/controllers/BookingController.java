package CourseBookingLab.CourseBookingLab.controllers;

import CourseBookingLab.CourseBookingLab.models.Booking;
import CourseBookingLab.CourseBookingLab.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(){
        List<Booking> foundBookings = bookingRepository.findAll();
        return new ResponseEntity<>(foundBookings, HttpStatus.OK);
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
