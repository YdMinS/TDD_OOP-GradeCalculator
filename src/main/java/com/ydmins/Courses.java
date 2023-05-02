package com.ydmins;

import java.util.List;

public class Courses {

    private final List<Course> courses;

    public Courses(List<Course> courses){
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        return courses.stream()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();
    }

    public int calculateTotalCompletedCredit() {
        // 수강신청 총학점
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
