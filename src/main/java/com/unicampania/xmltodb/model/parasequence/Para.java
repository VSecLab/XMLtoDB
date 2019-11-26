package com.unicampania.xmltodb.model.parasequence;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;
import java.util.ArrayList;
import java.util.List;

public class Para {


    @Getter
    @XmlAttribute(name = "id")
    private String id_para = new String();

    @Getter
    @XmlAttribute(name = "type")
    private String type = new String();


    @Getter
    @XmlMixed
    private List<String> testo = new ArrayList<>();                //questo deve contenere il testo del para

    @Getter
    @XmlElement(name = "xref")
    private List<Xref> xrefs = new ArrayList<>();

    @Getter
    @XmlElement(name = "url")
    private List<Url> urls = new ArrayList<>();

    @Getter
    @XmlElement(name = "list")
    private List<com.unicampania.xmltodb.model.parasequence.List> lists = new ArrayList<>();

    @Getter
    @XmlElement(name = "bold")
    private List<Bold> bolds = new ArrayList<>();

    @Getter
    @XmlElement(name = "italic")
    private List<Italic> italics = new ArrayList<>();

}
