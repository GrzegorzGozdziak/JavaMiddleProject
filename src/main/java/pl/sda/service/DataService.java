package pl.sda.service;

import org.apache.commons.io.FileUtils;
import pl.sda.model.Address;
import pl.sda.model.Company;
import pl.sda.model.User;
import pl.sda.xml.XMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public static List<String> printCompanyInfo(Company company) {

//        List<Address> address = new Address("kowalska", 10,1,"62-222", "Poznan", "Poland");
//        Company
        List<String> result = new ArrayList<>();
        result.add(company.getName());
        result.add(company.getAddress().toString());
        result.add(company.getNip());





//        nazwa
//                adres ul. asd
//                kod miasto
//                        NIP

        return result;
    }
}
