package edu.matc.entity;

import org.apache.log4j.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static java.lang.Math.*;

/**
 * A class to represent a user.
 *
 * @author pwaite
 */
public class User {

    private final Logger logger = Logger.getLogger(this.getClass());
    private double CONVERT_TO_YEARS = 1 / 1000 / 60 / 60 / 24 / 365;

    private String firstName;
    private String lastName;
    private String userid;
    private Calendar dateOfBirth;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param userid    the userid
     */
    public User(String firstName, String lastName, String userid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userid = userid;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets userid.
     *
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets userid.
     *
     * @param userid the userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = convertToCalendar(dateOfBirth);
    }

    public int determineAge(Calendar dateOfBirth) {
        int age = 0;
        // Compares date of birth to current date for milliseconds between
        int time = dateOfBirth.compareTo(Calendar.getInstance());
        // Convert milliseconds to years, rounded down
        age = (int) floor(time * CONVERT_TO_YEARS);
        logger.info("The age is : " + age);
        return age;
    }

    public Calendar convertToCalendar(String dateOfBirth) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat convert = new SimpleDateFormat("YYYY/MM/DD", Locale.ENGLISH);
        try {
            calendar.setTime(convert.parse(dateOfBirth));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }


}