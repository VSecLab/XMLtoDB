package com.unicampania.xmltodb.model.parasequence.table;



import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "thead")
public class Thead {

    @Getter
    private String id_thead;

    @Getter
    @XmlElement(name = "row")
    private Row row;


}
