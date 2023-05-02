package com.ydmins;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 요구사항
 * 평균학점 계산 방법 = (학점수 * 교과목 편점)의 합계 / 수강신청 총합점 수
 * 일급 컬렉션 사용
 */
public class GradeCalculatorTest {
    // 도메인 고민 && 객체들 간의 관계 (머리, 그림 구상)
    // 학점계산기 도메인 : 이수한 과목, 학점계산기
    // 여기 모든 객체가 도출되는 건 아니다
    // 동적인 객체를 정적인 타입으로 추상화해서 도메인 모델링
    // 이수한 과목 : 객체지향프로그래밍, 자료구조, 영어회화(동적) -> 과목 클래스(정적)
    // 책임을 할당하며 협력을 설계
    // 이수한 과목을 전달하여 평균학점 계산 요청 --> 학점 계산기
    //  ㄴ 학점계산기 (학점수 * 교과목 평점)의 합계 --> 과목클래스
    //  ㄴ 수강신청 총학점수 --> 과목클래스
    // 구현

    // 학점을 계산하기 위해선 먼저 이수한 과목들부터 있어야 한다.
    // com.ydmins.CourseTest클래스를 만든다.
    @DisplayName("평균 학점을 계산한다.")
    @Test
    void calculateGradeTest() {
        List<Course> courses = List.of(
                new Course("OOP", 3, "A+"),
                new Course("자료구조", 3, "A+")
        );
        GradeCalculator gradeCalculator = new GradeCalculator(courses);
        double gradeResult = gradeCalculator.calculateGrade();

        Assertions.assertThat(gradeResult).isEqualTo(4.5);
    }
}

