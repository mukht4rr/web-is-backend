package com.web_is.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_title")
    private String courseTitle;

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "status")
    private String status;

    @Column(name = "attendance_code")
    private String attendanceCode;

    @Column(name = "enrollment_key")
    private String enrollmentKey;

    @Column(name = "attendance_code_status")
    private String attendanceCodeStatus;

    @Column(name = "date")
    private LocalDateTime date;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<LecturerCourse> lecturerCourses;

    public String getAttendanceCodeStatus() {
        return attendanceCodeStatus;
    }

    public void setAttendanceCodeStatus(String attendanceCodeStatus) {
        this.attendanceCodeStatus = attendanceCodeStatus;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getEnrollmentKey() {
        return enrollmentKey;
    }

    public void setEnrollmentKey(String enrollmentKey) {
        this.enrollmentKey = enrollmentKey;
    }

    public String getAttendanceCode() {
        return attendanceCode;
    }

    public void setAttendanceCode(String attendanceCode) {
        this.attendanceCode = attendanceCode;
    }

    // Getter and Setter for courseId
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    // Getter and Setter for courseTitle
    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    // Getter and Setter for courseCode
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    // Getter and Setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<LecturerCourse> getLecturerCourses() {
        return lecturerCourses;
    }

    public void setLecturerCourses(List<LecturerCourse> lecturerCourses) {
        this.lecturerCourses = lecturerCourses;
    }

}
