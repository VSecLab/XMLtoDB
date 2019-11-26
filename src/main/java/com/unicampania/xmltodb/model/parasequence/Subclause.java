package com.unicampania.xmltodb.model.parasequence;


import lombok.Getter;


import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Subclause {

    @Getter
    @XmlElement
    private String id_subclauses = new String();

    @Getter
    @XmlElement
    private Parasequence parasequence = new Parasequence();
}
