package com.unicampania.xmltodb.model.parasequence;

import com.sun.xml.txw2.annotation.XmlNamespace;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlType.*;


public class Acronym {

    @Getter
    @XmlAttribute(name = "id")
    private String id_acronym = new String();

}
