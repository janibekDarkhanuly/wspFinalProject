import localization.Localization;
import views.BaseView;

public class Main {
    public static void main(String[] args) {
        Localization ln = new Localization();
        ln.setLanguage("ru");
        System.out.println(ln.getMessage("greeting"));

        BaseView.welcome();

    }
}
