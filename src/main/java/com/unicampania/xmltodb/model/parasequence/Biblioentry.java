package com.unicampania.xmltodb.model.parasequence;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "biblioentry")
public class Biblioentry {

    @Getter
    @XmlAttribute(name = "id")
    private String id_biblioentry = new String();

    @Getter
    @XmlElement(name = "biblioterm")
    private Biblioterm biblioterm = new Biblioterm();

    @Getter
    @XmlElement(name = "bibliodef")
    private Bibliodef bibliodef = new Bibliodef();

}
