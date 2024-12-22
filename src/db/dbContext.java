package db;

import java.util.Vector;

import models.*;

public class dbContext {
    private static final long serialVersionUID = 1L;

    private static String fullPath = "C:\\Users\\user\\Desktop\\wspFInalProject\\WSP\\src\\data\\";
    private static dbContext db = new dbContext();

    public static Vector<Teacher> teacher = new Vector<Teacher>();
    public static Vector<Admin> admin = new Vector<Admin>();
    public static Vector<Student> student = new Vector<Student>();
    public static Vector<Manager> manager = new Vector<Manager>();
    public static Vector<Researcher> researcher = new Vector<Researcher>();
    public static Vector<Librarian> librarian = new Vector<Librarian>();
    public static Vector<Course> courses = new Vector<Course>();




    {

        this.teacher = getTeachers();
        this.admin = getAdmin();
        this.student = getStudent();
        this.manager = getManagers();
        this.researcher = getResearchers();
        this.librarian = getLibrarians();
        this.courses = getCourse();
    }
    public static Vector<Course> getCourse() {
        Object o = ReaderWriter.deserialize(fullPath + "coursesInfo.txt");

        if (o instanceof Vector) {
            return (Vector<Course>) o;
        }
        return null;
    }


    public static Vector<Librarian> getLibrarians() {
        Object o = ReaderWriter.deserialize(fullPath + "librarian.txt");

        if (o instanceof Vector) {
            return (Vector<Librarian>) o;
        }
        return null;
    }

    public static Vector<Researcher> getResearchers() {
        Object o = ReaderWriter.deserialize(fullPath + "researcher.txt");

        if (o instanceof Vector) {
            return (Vector<Researcher>) o;
        }
        return null;
    }

    public static Vector<Manager> getManagers() {
        Object o = ReaderWriter.deserialize(fullPath + "manager.txt");

        if (o instanceof Vector) {
            return (Vector<Manager>) o;
        }
        return null;
    }

    public static Vector<Student> getStudent() {
        Object o = ReaderWriter.deserialize(fullPath + "student.txt");

        if (o instanceof Vector) {
            return (Vector<Student>) o;
        }
        return null;
    }

    private dbContext() {

    }

    // ...

    public static Vector<Teacher> getTeachers() {
        Object o = ReaderWriter.deserialize(fullPath + "teacher.txt");

        if (o instanceof Vector) {
            return (Vector<Teacher>) o;
        }
        return null;
    }

    public static boolean saveTeachers() {
        return ReaderWriter.serialize(teacher, fullPath + "teacher.txt");
    }
    public static boolean saveStudents() {
        return ReaderWriter.serialize(student, fullPath + "student.txt");
    }
    public static boolean saveAdmin() {
        return ReaderWriter.serialize(admin, fullPath + "admin.txt");
    }
    public static boolean saveManagers(){
        return ReaderWriter.serialize(manager, fullPath + "manager.txt");
    }
    public static boolean saveLibrarian(){
        return ReaderWriter.serialize(librarian, fullPath + "librarian.txt");
    }
    public static boolean saveResearcher(){
        return ReaderWriter.serialize(researcher, fullPath + "researcher.txt");
    }
    public static boolean saveCourseInfo(){
        return ReaderWriter.serialize(courses, fullPath + "coursesInfo.txt");
    }


    public static dbContext getDb() {
        return db;
    }


    public static Vector<Admin> getAdmin() {
        Object o = ReaderWriter.deserialize(fullPath + "admin.txt");
        if (o instanceof Vector) {
            return (Vector<Admin>) o;
        }
        return null;
    }

}