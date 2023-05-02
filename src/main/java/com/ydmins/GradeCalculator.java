package com.ydmins;

import java.util.List;

public class GradeCalculator {

    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }

    public double calculateGrade() {
        double mulipliedCreditAndCourseGrade = 0;
        for(Course course : courses){
            mulipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
        }

        // 수강신청 총학점
        int totalCompletedCredit = courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
        return mulipliedCreditAndCourseGrade/totalCompletedCredit;
    }
}
