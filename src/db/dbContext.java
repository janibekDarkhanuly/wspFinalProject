package db;

import java.util.Vector;

import models.Teacher;

public class dbContext {

    private static String fullPath = "C:\\Users\\user\\Desktop\\wspFInalProject\\WSP\\src\\data";
    private static dbContext db = new dbContext();

    public static Vector<Teacher> teacher;

    {

        this.teacher = getTeachers();
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

    public static dbContext getDb() {
        return db;
    }


}