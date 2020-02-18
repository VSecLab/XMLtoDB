package com.unicampania.xmltodb.model.evaluation_assurance_levels;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;

public class EalComponent {

    @Getter
    @XmlAttribute(name = "acomponent")
    private String acomponent;
}
