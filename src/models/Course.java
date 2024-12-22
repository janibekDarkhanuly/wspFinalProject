package models;

import java.io.Serializable;
import java.util.Vector;

public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int credits;
    private Vector<Teacher> instructors;
    private CourseType courseType;
    private Vector<Student> participants;
    private CoursePeriod period;
    private String id;
    public Course(String name,int credits,CourseType type,CoursePeriod period,String id) {
        this.name = name;
        this.credits = credits;
        this.courseType = type;
        this.period = period;
        this.id = id;
    }
    public void printParticipants(){
        for(int i = 0;i<participants.size();i++) {
            System.out.print(i + 1 + ". ");
            System.out.print(participants.get(i));
            System.out.println();
        }
    }
    public void printInstructors(){
        for(int i = 0;i<instructors.size();i++) {
            System.out.print(i + 1 + ". ");
            System.out.print(instructors.get(i));
            System.out.println();
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
    public Vector<Teacher> getInstructors() {
        return instructors;
    }
    public void assingInstructor(Teacher teacher) {
        instructors.add(teacher);
    }
    public void removeInstructor(Teacher teacher) {
        instructors.remove(teacher);
    }
    public Vector<Student> getParticipants() {
        return participants;
    }
    public void assingParticipant(Student student) {
        participants.add(student);
    }
    public void removeParticipant(Student student) {
        participants.remove(student);
    }
    public CourseType getCourseType() {
        return courseType;
    }
    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }
    public CoursePeriod getPeriod() {
        return period;
    }
    public void setPeriod(CoursePeriod period) {
        this.period = period;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


}
