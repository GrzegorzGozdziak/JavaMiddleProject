package pl.sda.service;

import org.apache.commons.io.FileUtils;
import pl.sda.model.User;
import pl.sda.xml.XMLFactory;

import java.io.File;
import java.io.IOException;

public class DataService {

    private File file;
    public DataService() {
        this.file = new File("C:\\Users\\RENT\\Desktop\\data.dat");
    }

    public void saveData(String xmlString) {

        try {
            FileUtils.touch(file);
            FileUtils.writeStringToFile(file, xmlString);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public User loadData() {
        User user = null;
        XMLFactory<User> xmlFactory = new XMLFactory<User>(User.class);
        String xml = null;
        try {
            xml = FileUtils.readFileToString(file, "UTF-8");
            user = xmlFactory.xmlToObject(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
