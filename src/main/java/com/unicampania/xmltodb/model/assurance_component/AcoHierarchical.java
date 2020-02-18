package com.unicampania.xmltodb.model.assurance_component;


import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class AcoHierarchical {

    @Getter
    private String id_acohierarchical;

    @Getter
    @XmlAttribute(name = "acomponent")
    private String acomponent;

}
