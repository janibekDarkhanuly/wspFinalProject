package Controller;

import models.*;

import java.util.Vector;

import db.dbContext;

public class UserController {

    public static boolean createUser(String username, String password, UserType type) {
        switch(type) {
            case RESEARCHER:
                Researcher r = new Researcher(username, password);
                dbContext.researcher.add(r);
                return dbContext.saveResearcher();
            case LIBRARIAN:
                Librarian librarian = new Librarian(username, password);
                dbContext.librarian.add(librarian);
                return dbContext.saveLibrarian();
            case ADMIN:
                Admin admin = new Admin(username, password);
                dbContext.admin.add(admin);
                return dbContext.saveAdmin();
            case TEACHER:
                Teacher newTeacher = new Teacher(username, password);
                dbContext.teacher.add(newTeacher);
                return dbContext.saveTeachers();
            case STUDENT:
                Student newStudent = new Student(username, password);
                dbContext.student.add(newStudent);
                return dbContext.saveStudents();
            case MANAGER:
                Manager newManager = new Manager(username, password);
                dbContext.manager.add(newManager);
                return dbContext.saveManagers();
            default:
                return false;
        }
    }

    public static Object getUsers(UserType type) {
        switch(type) {
            case STUDENT:
                return dbContext.getStudent();
            case MANAGER:
                return dbContext.getManagers();
            case LIBRARIAN:
                return dbContext.getLibrarians();
            case RESEARCHER:
                return dbContext.getResearchers();
            case ADMIN:
                return dbContext.getAdmin();
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
        else if(fileName.equals("student.txt")) {
            Vector<Student> students = (Vector<Student>) getUsers(UserType.STUDENT);
            for(Student s: students) {
                if (s.getUsername().equals(username) && s.getPassword().equals(password)){
                    return true;
                }
            }
        }
        else if(fileName.equals("manager.txt")) {
            Vector<Manager> managers = (Vector<Manager>) getUsers(UserType.MANAGER);
            for(Manager m: managers) {
                if (m.getUsername().equals(username) && m.getPassword().equals(password)){
                    return true;
                }
            }

        }
        else if(fileName.equals("admin.txt")) {
            Vector<Admin> admins = (Vector<Admin>) getUsers(UserType.ADMIN);
            for(Admin a: admins) {
                if (a.getUsername().equals(username) && a.getPassword().equals(password)){
                    return true;
                }
            }

        }
        else if(fileName.equals("librarian.txt")) {
            Vector<Librarian> librarians = (Vector<Librarian>) getUsers(UserType.LIBRARIAN);
            for(Librarian a: librarians) {
                if (a.getUsername().equals(username) && a.getPassword().equals(password)){
                    return true;
                }
            }

        }
        else if(fileName.equals("researcher.txt")) {
            Vector<Researcher> researchers = (Vector<Researcher>) getUsers(UserType.RESEARCHER);
            for(Researcher a: researchers) {
                if (a.getUsername().equals(username) && a.getPassword().equals(password)){
                    return true;
                }
            }
        }

        return false;
    }
}