package com.unicampania.xmltodb.model.parasequence;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;
import java.util.ArrayList;
import java.util.List;

public class Bold {

    @Getter
    @XmlElement
    private String id_bold = new String();

    @Getter
    @XmlElement
    private String testo = new String();

    @Getter
    @XmlElement(name = "xref")
    private List<Xref> xrefs = new ArrayList<>();

    @Getter
    @XmlElement(name = "italic")
    private List<Italic> italics = new ArrayList<>();
}
