package com.ydmins;

import java.util.List;

public class Courses {

    private final List<Course> courses;

    public Courses(List<Course> courses){
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        double mulipliedCreditAndCourseGrade = 0;
        for(Course course : courses){
            mulipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
        }
        return mulipliedCreditAndCourseGrade;
    }

    public int calculateTotalCompletedCredit() {
        // 수강신청 총학점
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
