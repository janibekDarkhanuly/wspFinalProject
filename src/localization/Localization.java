package localization;
import db.dbContext;

import java.util.HashMap;
import java.util.Map;
public class
Localization {
    private String language = null;
    private static Map<String, String> enData = new HashMap<>();
    private static Map<String, String> ruData = new HashMap<>();
    private static Map<String, String> kzData = new HashMap<>();

    public static Localization ln = new Localization();
    static{
        // Russian Data

        ruData.put("greeting", "Добро пожаловать");
        ruData.put("farewell", "Пока пока");


        //English Data
        enData.put("authorize", "Welcome to WSP!\nSelect your role:\n" +
                "1. Teacher\n" +
                "2. Manager\n" +
                "3. Student\n" +
                "4. Admin\n" +
                "5. Librarian\n" +
                "6. Researcher\n" +
                "0. Exit");
        enData.put("adminMenu","Welcome to WSP Admin Menu\n"+
                "1.Create a new user\n" +
                "2.Show list of users\n" +
                "3.Delete users\n" +
                "4.Exit");
        enData.put("adminMenu_chooseTypeOfUserstoShow","Choose type of Users to show!\n"+
                "1. Teacher\n" +
                "2. Manager\n" +
                "3. Student\n" +
                "4. Admin\n" +
                "5. Librarian\n" +
                "6. Researcher\n");
        enData.put("adminMenu_chooseTypeError", "Invalid option!");
        enData.put("Goodbye","Bye bye!");
        enData.put("Empty","The List is empty!");
        enData.put("adminDeleteOption","Choose type of User to delete!\n"+
                "1. Teacher\n" +
                "2. Manager\n" +
                "3. Student\n" +
                "4. Admin\n" +
                "5. Librarian\n" +
                "6. Researcher\n");
        enData.put("EnterUsername","Enter a Username");
        enData.put("EnterPassword","Enter a Password");
        enData.put("Good","Successful!");
        enData.put("Error","Error!");
        enData.put("adminCreateOption","Choose type of Users to create!\n"+
                "1. Teacher\n" +
                "2. Manager\n" +
                "3. Student\n" +
                "4. Admin\n" +
                "5. Librarian\n" +
                "6. Researcher\n");
        enData.put("GreetingMng","Welcome to Manager Control Panel!\n" +
                "1. Create a new Course\n"+
                "2. Delete a Course\n"+
                "3. Assign a Student to a Course\n+" +
                "4. Assing a Teacher to a Course\n"+
                "5. View list of Courses");
        enData.put("newCourse_courseName","Please enter a Course Name!");
        enData.put("newCourse_courseCredits","Please enter a Course Credits!");
        enData.put("newCourse_courseType","Please enter a Course Type!\n" +
                "1. Major\n" +
                "2. Minor\n"+
                "3. Free");
        enData.put("newCourse_coursePeriod","Please enter a Course Period!\n" +
                "1. Fall\n" +
                "2. Spring\n"+
                "3. Summer");
        enData.put("newCourse_courseId","Please enter a Course Id!");


        enData.put("","Bye bye!");
    }
    public Localization(){
    }
    public void setLanguage(String language){
        this.language = language;
    }
    public String getLanguage(){
        return language;
    }


    public String getMessage(String key) {
        switch (this.getLanguage()) {
            case "kz":
                return kzData.getOrDefault(key,"Хабарлама табылған жоқ");
            case "en":
                return enData.getOrDefault(key, "Message not found");
            case "ru":
                return ruData.getOrDefault(key, "Сообщение не найдено");
            default:
                return "Unsupported language";
        }
    }
}



