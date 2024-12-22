package Controller;

import models.*;

import java.util.Map;
import java.util.Vector;

import db.dbContext;

public class CourseController {
    public static boolean createCourse(String name,int credits,CourseType type,CoursePeriod period,String id) {
        Course course = new Course(name, credits, type, period,id);
        dbContext.courses.add(course);
        return dbContext.saveCourseInfo();
    }
    public static boolean deleteCourse(String id) {
        Vector<Course> courses = dbContext.getCourse();
        for(Course c : courses) {
            if(c.getId().equals(id)) {
                dbContext.courses.remove(c);
                return dbContext.saveCourseInfo();
            }
        }
        return false;
    }
    public static void printStudents(){
        Vector<Student> students = dbContext.getStudent();
        for(int i = 0;i<students.size();i++) {
            System.out.print(i + 1 + ". ");
            System.out.print(students.get(i));
            System.out.println();
        }
    }
    public static void printCourses(){
        Vector<Course> courses = dbContext.getCourse();
        int i = 0;
        for(Course c : courses) {
            i++;
            System.out.println(i +". " + c.getName() + " " + c.getId());
        }
    }
    public static boolean addStudent(int coursePosition,int StudentPosition){
        Vector<Course> courses = dbContext.getCourse();
        int i = 0;
        for(Course c : courses) {
            if(i == coursePosition - 1) {
                c.assingParticipant(c.getParticipants().get(StudentPosition - 1));
                return true;
            }

        }
        return false;
    }
    public static boolean addTeacher(int coursePosition,int TeacherPosition){
        Vector<Course> courses = dbContext.getCourse();
        int i = 0;
        for(Course c : courses) {
            if(i == coursePosition - 1) {
                c.assingInstructor(c.getInstructors().get(TeacherPosition - 1));
                return true;
            }

        }
        return false;
    }

    public static Vector<Course> getCourses() {
        return dbContext.courses;
    }


}
