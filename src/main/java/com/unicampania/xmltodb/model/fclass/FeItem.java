package com.unicampania.xmltodb.model.fclass;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;

public class FeItem {

    @Getter
    @XmlMixed
    private String text;

    @Getter
    @XmlElement(name = "fe-assignment")
    private FeAssignment feAssignment = new FeAssignment();

}
