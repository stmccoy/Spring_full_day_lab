package CourseBookingLab.CourseBookingLab.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.util.StringUtils;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnoreProperties({"bookings"})
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonIgnoreProperties({"bookings"})
    private Course course;

    public Booking(String date, Customer customer, Course course) {
        this.date = date;
        this.customer = customer;
        this.course = course;
    }

    public Booking() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
