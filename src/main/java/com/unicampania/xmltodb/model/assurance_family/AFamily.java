package com.unicampania.xmltodb.model.assurance_family;


import com.unicampania.xmltodb.model.assurance_component.AComponent;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class AFamily {


    @Getter
    @XmlAttribute(name = "name")
    private String name = new String();

    @Getter
    @XmlAttribute(name = "id")
    private String id_afamily = new String();

    @Getter
    @XmlElement(name = "af-objectives")
    private AfObjectives afObjectives;

    @Getter
    @XmlElement(name ="af-overview")
    private AfOverview afOverview;

    @Getter
    @XmlElement(name = "af-levelling-criteria")
    private AfLevellingCriteria afLevellingCriteria;

    @Getter
    @XmlElement(name = "af-application-notes")
    private AfApplicationNotes afApplicationNotes;

    @Getter
    @XmlElement(name = "a-component")
    private List<AComponent> aComponentList;


}
