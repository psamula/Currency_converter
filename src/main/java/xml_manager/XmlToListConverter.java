package xml_manager;

import domain.CourseTable;
import domain.CustomCurrency;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.util.List;

import static java.lang.System.exit;

public class XmlToListConverter {
    public static List<CustomCurrency> convert(Class c, String urlString) {
        try {

            var is = URLInputStreamProvider.provide(urlString);

            var context = JAXBContext.newInstance(c);
            Unmarshaller un = context.createUnmarshaller();
            CourseTable ct = (CourseTable) un.unmarshal(is);


            var aa =  ct.getCurrencyExchangeList();
            return ct.getCurrencyExchangeList();

        }
        catch (Exception e) {
            e.printStackTrace();
            exit(-4);
        }
        return null;
    }
}
