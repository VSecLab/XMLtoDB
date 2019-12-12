package com.unicampania.xmltodb.model.parasequence;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "url")
public class Url {

    @Getter
    @XmlAttribute(name = "id")
    private String id_url = new String();
}
