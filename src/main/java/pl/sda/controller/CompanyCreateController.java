package pl.sda.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import pl.sda.model.Address;
import pl.sda.model.Company;
import pl.sda.model.StreetPrefix;

public class CompanyCreateController {

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
    void addCompanyOnAction(ActionEvent event) {
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
        company.setAddress(address);
        company.setNip(nipField.getText());
        System.out.println(company);


    }

    @FXML
    void initialize(){
        ToggleGroup group = new ToggleGroup();
        streetRadio.setToggleGroup(group);
        placeRadio.setToggleGroup(group);
        avenueRadio.setToggleGroup(group);
    }

}
