package com.unicampania.xmltodb.model.parasequence.table;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tfoot")
public class Tfoot {
    @Getter
    private String id_tfoot;

    @Getter
    @XmlElement(name = "row")
    private Row row;
}
