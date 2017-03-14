package pl.sda.service;

import pl.sda.model.User;
import pl.sda.xml.XMLFactory;

public class UserService {

    public boolean authenticate(User user) {

        DataService dataService = new DataService();

        User userFromFile = dataService.loadData();;
        return user.equals(userFromFile);
    }
}
