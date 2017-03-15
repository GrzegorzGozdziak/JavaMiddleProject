package service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sda.model.Address;
import pl.sda.model.Company;
import pl.sda.model.StreetPrefix;
import pl.sda.model.User;
import pl.sda.service.DataService;

import java.util.List;

public class DataServiceTest {

    private DataService dataService;
    private String xmlString="<?xml version=\"1.0\" encoding=\"UTF-8\" " +
            "standalone=\"yes\"?><User><login>kowalski</login><password>abc123</password></User>";
    private User user;
    private User userXML;
    private Company company;

    public DataServiceTest() {
    }

    @Before
    public void setUp() {
        dataService = new DataService();
        userXML = new User("kowalski", "abc123");
        company = new Company();
        company.setName("Biedronka");
        company.setAddress(new Address("Nowa",10,10,"55-555","Poznan","Polska", StreetPrefix.STREET));
        company.setNip("123131233");
        company.setRegon("12312332");


    }

    public void loadData() {
        user =  dataService.loadData();
    }

    public void saveData() {
        dataService.saveData(xmlString);
    }

    @Test
    public void saveAndLoadData()  {
        saveData();
        loadData();
        Assert.assertTrue(user.equals(userXML));
    }

    @Test
    public void printCompanyInfo() {
        List<String> companyInfo = dataService.printCompanyInfo(company);
        boolean resultAssert = true;
        resultAssert &= companyInfo.get(0).equals("Biedronka");
        resultAssert &= companyInfo.get(1).equals("ul. Nowa 10/10\n55-555 Poznan Polska");

        resultAssert &= companyInfo.get(2).equals("123131233");
        for(String line : companyInfo){
            System.out.println(line);
        }
        Assert.assertTrue(resultAssert);
    }

}
