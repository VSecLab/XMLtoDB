package com.unicampania.xmltodb.model.assurance_paradigm;

import com.unicampania.xmltodb.model.assurance_family.AFamily;
import com.unicampania.xmltodb.model.parasequence.Xref;
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
    private MaIntroduction maIntroduction = new MaIntroduction();

    @Getter
    @XmlElement(name = "ac-application-notes")
    private AcApplicationNotes acApplicationNotes = new AcApplicationNotes();

    @Getter
    @XmlElement(name = "ma-objectives")
    private MaObjectives maObjectives = new MaObjectives();

    @Getter
    @XmlElement(name = "ma-application-notes")
    private MaApplicationNotes maApplicationNotes = new MaApplicationNotes();

    @Getter
    @XmlElement(name = "a-family")
    private List<AFamily> aFamilies = new ArrayList<>();


}
