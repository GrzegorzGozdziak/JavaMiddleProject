package pl.sda.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import pl.sda.model.Address;
import pl.sda.model.Company;
import pl.sda.model.StreetPrefix;
import pl.sda.pdf.PdfFactory;
import pl.sda.service.DataService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompanyCreateController extends Controller{

    @FXML
    private TextField postCodeField;

    @FXML
    private RadioButton placeRadio;

    @FXML
    private TextField houseNumberField;

    @FXML
    private Button submit;

    @FXML
    private TextField cityField;

    @FXML
    private RadioButton streetRadio;

    @FXML
    private TextField streetNameField;

    @FXML
    private TextField flatNumberField;

    @FXML
    private TextField companyNameTextField;

    @FXML
    private RadioButton avenueRadio;

    @FXML
    private TextField countryField;

    @FXML
    private TextField nipField;
    private StreetPrefix streetPrefix;

    @FXML
    void choosePrefixOnAction(ActionEvent event) {
        if (event.getSource() instanceof RadioButton){
            RadioButton currentPrefixRadioButton = (RadioButton) event.getSource();
//            currentPrefixRadioButton.get
            String buttonName = currentPrefixRadioButton.getText();
            switch (buttonName){
                case "Ulica":
                    streetPrefix = StreetPrefix.STREET;
                    break;
                case "Aleja":
                    streetPrefix = StreetPrefix.AVENIUE;
                    break;
                case "Plac":
                    streetPrefix = StreetPrefix.SQUARE;
                    break;
            }
        }
    }

    @FXML
    Company addCompanyOnAction() {
        return bindToModelCompany();
    }

    private Company bindToModelCompany() {
        Company company = new Company();
        company.setName(companyNameTextField.getText());
        Address address = new Address();
        address.setStreetPrefix(streetPrefix);
//        StreetPrefix prefix = new StreetPrefix(ra);
//        address.setStreet;
        address.setStreetName(streetNameField.getText());
        address.setHouseNumber(Integer.parseInt(houseNumberField.getText()));
        address.setFlatNumber(Integer.parseInt(flatNumberField.getText()));

        address.setPostalCode(postCodeField.getText());
        address.setCity(cityField.getText());
        address.setCountry(countryField.getText());
        company.setAddress(address);
        company.setNip(nipField.getText());
//        System.out.println(company);
        DataService dataService = new DataService();
        dataService.printOutCompanyInfo(company);

        return company;
    }

    @FXML
    void initialize(){
        ToggleGroup group = new ToggleGroup();
        streetRadio.setToggleGroup(group);
        placeRadio.setToggleGroup(group);
        avenueRadio.setToggleGroup(group);
//        validatePostalCode();
    }

    private void validatePostalCode() {
//        postCodeField.textProperty().addListener((observable, oldValue, newValue) -> {
//            System.out.println("textfield changed from " + oldValue + " to " + newValue);
            Pattern zipPattern = Pattern.compile("(^\\d{2}-\\d{3}$)");
            Matcher zipMatcher = zipPattern.matcher(postCodeField.getText());
            if (zipMatcher.find()) {
                showAlertConfirmation("Good data");
            } else {
                showAlertError("Wrong Posta Code");
            }
    }



    @FXML
    void makePdfOnAction(ActionEvent event) {


        PdfFactory pdfFactory = new PdfFactory();
        pdfFactory.CreateCompanyPDF(addCompanyOnAction());
    }

    @FXML
    void validateOnAction(ActionEvent event) {
        validatePostalCode();
    }

}
