import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sda.model.User;
import pl.sda.service.DataService;

public class DataServiceTest {

    private DataService dataService;
    private String xmlString="<?xml version=\"1.0\" encoding=\"UTF-8\" " +
            "standalone=\"yes\"?><User><login>kowalski</login><password>abc123</password></User>";
    private User user;
    private User userXML;

    public DataServiceTest() {
    }

    @Before
    public void setUp() {
        dataService = new DataService();
        userXML = new User("kowalski", "abc123");
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


}
