package com.unicampania.xmltodb.model.parasequence;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Item {

    @Getter
    @XmlElement
    private String id_item = new String();

    @Getter
    @XmlElement(name = "para")
    private List<Para> paras = new ArrayList<>();

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

    @Getter
    @XmlElement(name = "selection")
    private List<Selection> selections = new ArrayList<>();

}
