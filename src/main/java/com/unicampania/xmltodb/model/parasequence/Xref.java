package com.unicampania.xmltodb.model.parasequence;

import lombok.Getter;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xref")
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


    /*void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
        System.out.println("After Unmarshaller Callback");
    }*/
}
