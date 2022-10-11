package domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "tabela_kursow")
@XmlAccessorType(XmlAccessType.FIELD)
public class CourseTable {

    @XmlElement(name = "pozycja")
    private List<CustomCurrency> customCurrencyList = null;

    public List<CustomCurrency> getCurrencyExchangeList() {
        return this.customCurrencyList;
    }
    public void setCurrencyExchangeList(List<CustomCurrency> customCurrencyList) {
        this.customCurrencyList = customCurrencyList;
    }
}
