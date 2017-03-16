package pl.sda.pdf;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;
import pl.sda.model.Company;
import pl.sda.service.DataService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;

public class PdfFactory {


    public static void CreatePDF() {
        Properties properties = DataService.loadProperties();
        String pdfPath = properties.getProperty("pdfPath");
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath + File.separator + "file.pdf"));
            document.open();
            document.add(new Paragraph("Hello World"));
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void CreateCompanyPDF(Company company) {
        DataService dataService = new DataService();
        List<String> list = dataService.printCompanyInfo(company);
        Properties properties = DataService.loadProperties();
        String pdfPath = properties.getProperty("pdfPath");
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath + File.separator + "file.pdf"));
            document.setPageSize(new Rectangle(180,240));
            document.open();
            for (String e : list) {

                document.add(new Paragraph(e));
            }
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
