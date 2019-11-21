package com.unicampania.xmltodb.model.parasequence;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;

public class Glossentry {

    @Getter
    @XmlElement(name = "id")
    private String id;

}
