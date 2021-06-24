package CourseBookingLab.CourseBookingLab.models;

public enum STAR_RATINGS {

    five(5),
    four(4),
    three(3),
    two(2),
    one(1),
    zero(0);

    private int value;

    STAR_RATINGS(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
