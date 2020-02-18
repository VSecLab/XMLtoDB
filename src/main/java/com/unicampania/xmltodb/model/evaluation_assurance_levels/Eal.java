package com.unicampania.xmltodb.model.evaluation_assurance_levels;



import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "eal")
public class Eal {

    @Getter
    @XmlAttribute(name = "id")
    private String id_eal;

    @Getter
    @XmlAttribute(name = "name")
    private String name;

    @Getter
    @XmlElement(name = "eal-objectives")
    private EalObjectives ealObjectives;

    @Getter
    @XmlElement(name = "eal-assurance-components")
    private EalAssuranceComponents ealAssuranceComponents;

    @Getter
    @XmlElement(name = "eal-component")
    private List<EalComponent> ealComponentList = new ArrayList<>();
}
