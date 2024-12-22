package views;

import Controller.CourseController;
import models.*;

import java.util.Map;
import java.util.Scanner;

import static localization.Localization.ln;



public class ManagerView {
    private static Scanner in = new Scanner(System.in);
    private static final Map<Integer, CourseType> courseTypeMap = Map.of(
            1, CourseType.MAJOR,
            2, CourseType.MINOR,
            3, CourseType.FREE
    );
    private static final Map<Integer, CoursePeriod> CoursePeriddMap = Map.of(
            1, CoursePeriod.FALL,
            2, CoursePeriod.SPRING,
            3, CoursePeriod.SUMMER
    );



    public static void ManagerPanel() {
        System.out.println(ln.getMessage("GreetingMng"));
        int option = in.nextInt();
        if(option == 1){
            System.out.println(ln.getMessage("newCourse_courseName"));
            String courseName = in.next();
            System.out.println(ln.getMessage("newCourse_courseCredits"));
            int courseCredits = in.nextInt();
            System.out.println(ln.getMessage("newCourse_courseType"));
            int type = in.nextInt();
            CourseType t = courseTypeMap.get(type);
            System.out.println(ln.getMessage("newCourse_coursePeriod"));
            int periodtype = in.nextInt();
            CoursePeriod p = CoursePeriddMap.get(periodtype);
            System.out.println(ln.getMessage("newCourse_courseId"));
            String courseId = in.next();
            boolean res = CourseController.createCourse(courseName,courseCredits,t,p,courseId);
            if(res){
                System.out.println(ln.getMessage("Good"));
            }
            else{
                System.out.println(ln.getMessage("Error"));
            }
        }
        if(option == 5){
            CourseController.printCourses();
        }

    }


}
