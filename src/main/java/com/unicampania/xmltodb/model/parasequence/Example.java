package com.unicampania.xmltodb.model.parasequence;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;

public class Example {

    @Getter
    @XmlElement(name = "id")
    private String id_example = new String();

    @Getter
    @XmlElement(name = "exampleterm")
    private Exampleterm exampleterm;

    @Getter
    @XmlElement(name = "exampledef")
    private Exampledef exampledef;


}
