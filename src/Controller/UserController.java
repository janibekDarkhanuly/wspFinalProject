package Controller;

import models.UserType;
import models.Student;

import java.util.Vector;

import db.dbContext;
import models.Manager;
import models.Teacher;
import models.User;

public class UserController {

    public static boolean createUser(
            String username,
            String password,
            UserType type) {
        switch(type) {
            case TEACHER:
                Teacher newTeacher = new Teacher(username, password);
                dbContext.teacher.add(newTeacher);
                return dbContext.saveTeachers();
            case STUDENT:
                Student newStudent = new Student(username, password);
                break;
            case MANAGER:
                Manager newManager = new Manager(username, password);
                break;
            default:
                return false;
        }

        return true;
    }

    public static Object getUsers(UserType type) {
        switch(type) {
            case TEACHER:
                return dbContext.getTeachers();
            default:
                return null;
        }
    }

    public static boolean authorize(String fileName, String username, String password) {
        if(fileName.equals("teacher.txt")) {
            Vector<Teacher> teachers = (Vector<Teacher>) getUsers(UserType.TEACHER);

            for(Teacher t: teachers) {
                if (t.getUsername().equals(username)
                        && t.getPassword().equals(password))
                    return true;
            }
        }

        return false;
    }
}