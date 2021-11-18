import java.util.List;

public class Main {

    public static void main(String[] args) {
        ListManager manager = ListManager.getInstance();
        Admin admin = new Admin("admin", "010", "admin@gmail.com", "admin");
        manager.addToAdmin(admin);
        Menu menu = new Menu();
        menu.startMenu();
    }
}
