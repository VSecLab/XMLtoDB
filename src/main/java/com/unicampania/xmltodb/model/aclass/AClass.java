package com.unicampania.xmltodb.model.aclass;

import com.unicampania.xmltodb.model.fclass.FcIntroduction;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "a-class")
public class AClass {

    @Getter
    @XmlAttribute(name = "id")
    private String id;

    @Getter
    @XmlAttribute(name="name")
    private String name;

    @Getter
    @XmlElement(name = "ac-introduction")
    private AcIntroduction acIntroduction = new AcIntroduction();
}
