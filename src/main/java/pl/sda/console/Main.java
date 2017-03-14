package pl.sda.console;

import pl.sda.model.User;
import pl.sda.service.DataService;
import pl.sda.service.UserService;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        login(scanner);

//        DataService dataService = new DataService();
//        User user = new User();
//        String xmlUser = user.toString();
//        try {
//            dataService.saveData(xmlUser);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private static void login(Scanner scanner) {

        UserService userService = new UserService();
        boolean isLogin = false;
        while(!isLogin) {
            System.out.println("Enter Your LOGIN please:");
            String login = scanner.nextLine();
            System.out.println("Enter Your PASSWORD please:");
            String password = scanner.nextLine();

            User user = new User(login, password);
            isLogin = userService.authenticate(user);
            if(isLogin) {
                System.out.println("U R LOG IN");
            } else {
                System.out.println("WRONG PASSWORD!");
            }
        }
    }
}
