package com.unicampania.xmltodb.model.parasequence.table;



import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tgroup")
public class Tgroup {

    @Getter
    private String id_tgroup;

    @Getter
    @XmlElement(name = "cols")
    private String cols;

    @Getter
    @XmlElement(name = "thead")
    private Thead thead;

    @Getter
    @XmlElement(name = "tfoot")
    private Tfoot tfoot;

    @Getter
    @XmlElement(name = "tbody")
    private Tbody tbody = new Tbody();
}
