package xml_manager;

import domain.CourseTable;
import domain.CustomCurrency;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class XMLhandler {
    public static List<CustomCurrency> convert(Class c, String filename) {
        try {
            var context = JAXBContext.newInstance(c);
            Unmarshaller un = context.createUnmarshaller();
            CourseTable ct = (CourseTable) un.unmarshal(new File(filename));
            return ct.getCurrencyExchangeList();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
