package com.unicampania.xmltodb.model.parasequence;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;

public class Xref {

    @Getter
    @XmlElement(name = "show")
    private String show;

    @Getter
    @XmlElement(name = "id")
    private String id;

    @Override
    public String toString() {
        return  id.toUpperCase().replaceAll ("\r\n", " ").trim() + " " ;
    }
}
