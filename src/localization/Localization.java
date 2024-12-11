package localization;
import java.util.HashMap;
import java.util.Map;
public class Localization {
    private String language = null;
    private static Map<String, String> enData = new HashMap<>();
    private static Map<String, String> ruData = new HashMap<>();
    private static Map<String, String> kzData = new HashMap<>();
    static{
        // Russian Data

        ruData.put("greeting", "Добро пожаловать");
        ruData.put("farewell", "Пока пока");


        //English Data
        enData.put("greeting", "Welcome!");
        enData.put("farewell", "Goodbye!");


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
            case "en":
                return enData.getOrDefault(key, "Message not found");
            case "ru":
                return ruData.getOrDefault(key, "Сообщение не найдено");
            default:
                return "Unsupported language";
        }
    }
}



