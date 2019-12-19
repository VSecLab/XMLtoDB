package com.unicampania.xmltodb.model.parasequence.table;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "table")
public class Table {

    @Getter
    @XmlAttribute(name = "id")
    private String id_table = new String();

    @Getter
    @XmlAttribute(name = "width")
    private String width = new String();

    @Getter
    @XmlElement(name = "tgroup")
    private List<Tgroup> tgroupList = new ArrayList<>();


}
