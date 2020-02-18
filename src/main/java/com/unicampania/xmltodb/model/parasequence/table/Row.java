package com.unicampania.xmltodb.model.parasequence.table;


import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "row")
public class Row {

    @Getter
    private String id_row;

    @Getter
    @XmlElement(name = "entry")
    private Entry entry;
}
