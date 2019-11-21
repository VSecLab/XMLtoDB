package com.unicampania.xmltodb.model.parasequence;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;

public class Url {

    @Getter
    @XmlAttribute(name = "id")
    private String id;
}
