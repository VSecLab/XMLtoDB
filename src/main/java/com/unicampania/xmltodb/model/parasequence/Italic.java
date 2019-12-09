package com.unicampania.xmltodb.model.parasequence;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;
import java.util.ArrayList;
import java.util.List;

public class Italic {

    @Getter
    @XmlElement
    private String id_italic = new String();

    @Getter
    @XmlElement
    private String testo = new String();

    @Getter
    @XmlElement(name = "xref")
    private List<Xref> xrefs = new ArrayList<>();

    @Getter
    @XmlElement(name = "bold")
    private List<Bold> bolds = new ArrayList<>();

    @Override
    public String toString() {
        return  testo.replaceAll ("\r\n", " ").trim() + " " ;
    }

}
