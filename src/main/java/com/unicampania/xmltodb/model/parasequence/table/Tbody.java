package com.unicampania.xmltodb.model.parasequence.table;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "tbody")
public class Tbody {

    @Getter
    private String id_tbody;

    @Getter
    @XmlElement(name = "row")
    private Row row;
}
