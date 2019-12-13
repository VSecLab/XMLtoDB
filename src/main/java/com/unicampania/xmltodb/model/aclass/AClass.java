package com.unicampania.xmltodb.model.aclass;

import com.unicampania.xmltodb.model.fclass.FcIntroduction;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "a-class")
public class AClass {

    @Getter
    @XmlAttribute(name = "id")
    private String id;

    @Getter
    @XmlAttribute(name = "name")
    private String name;

    @Getter
    @XmlElement(name = "ac-introduction")
    private AcIntroduction acIntroduction = new AcIntroduction();

    @Getter
    @XmlElement(name = "ac-overview")
    private AcOverview acOverview = new AcOverview();

    @Getter
    @XmlElement(name = "ma-introduction")
    private MaIntroduction maIntroduction;

    @Getter
    @XmlElement(name = "ac-application-notes")
    private AcApplicationNotes acApplicationNotes;

    @Getter
    @XmlElement(name = "ma-objectives")
    private MaObjectives maObjectives;

    @Getter
    @XmlElement(name = "ma-application-notes")
    private MaApplicationNotes maApplicationNotes = new MaApplicationNotes();

    @Getter
    @XmlElement(name = "a-family")
    private List<AFamily> aFamilies = new ArrayList<>();

}
