package com.unicampania.xmltodb.model.parasequence;

import com.sun.xml.txw2.annotation.XmlElement;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "table")
public class Table {

    @Getter
    @XmlAttribute(name = "id")
    private String id_table = new String();

    @Getter
    @XmlAttribute(name = "width")
    private String width = new String();
}
