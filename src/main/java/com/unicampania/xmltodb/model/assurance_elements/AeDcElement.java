package com.unicampania.xmltodb.model.assurance_elements;

import lombok.Getter;
import javax.xml.bind.annotation.XmlElement;

public class AeDcElement {

    @Getter
    @XmlElement(name = "id")
    private String id_aedcelement;
}
