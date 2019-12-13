package com.unicampania.xmltodb.model.parasequence;

import com.sun.xml.txw2.annotation.XmlNamespace;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlType.*;

@XmlRootElement(name = "acronym")
public class Acronym {

    @Getter
    @XmlAttribute(name = "id")
    private String id_acronym = new String();

    @Getter
    @XmlElement(name = "acronymterm")
    private Acronymterm acronymterm = new Acronymterm();

    @Getter
    @XmlElement(name = "acronymdef")
    private Acronymdef acronymdef = new Acronymdef();

}
