package com.unicampania.xmltodb.model.parasequence;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;


public class Glossentry {

    @Getter
    @XmlAttribute(name = "id")
    private String id_glossentry = new String();

    @Getter
    @XmlElement(name = "glossterm")
    private Glossterm glossterm = new Glossterm();

    @Getter
    @XmlElement(name = "glossalt")
    private Glossalt glossalt;

    @Getter
    @XmlElement(name = "glossdef")
    private Glossdef glossdef = new Glossdef();

    @Getter
    @XmlElement(name = "glosssource")
    private Glosssource glosssource;

    @Getter
    @XmlElement(name = "glossnote")
    private List<Glossnote> glossnotes;


}
