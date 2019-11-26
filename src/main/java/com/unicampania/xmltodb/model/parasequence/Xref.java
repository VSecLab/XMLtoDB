package com.unicampania.xmltodb.model.parasequence;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;

public class Xref {

    @Getter
    @XmlAttribute(name = "show")
    private String show = new String();

    @Getter
    @XmlAttribute(name = "id")
    private String id_xref = new String();

    @Override
    public String toString() {
        return  id_xref.toUpperCase().replaceAll ("\r\n", " ").trim() + " " ;
    }
}
