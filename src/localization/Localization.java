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
                "3.Exit");
        enData.put("adminMenu_chooseTypeOfUserstoShow","Choose type of Users to show!"+
                "1. Teacher\n" +
                "2. Manager\n" +
                "3. Student\n" +
                "4. Admin\n" +
                "5. Librarian\n" +
                "6. Researcher\n");
        enData.put("adminMenu_chooseTypeError", "Invalid option!");
        enData.put("Goodbye","Bye bye!");
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



