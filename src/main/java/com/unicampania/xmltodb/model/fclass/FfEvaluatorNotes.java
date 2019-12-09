package com.unicampania.xmltodb.model.fclass;

import com.unicampania.xmltodb.model.parasequence.Para;
import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;

public class FfEvaluatorNotes {

    @Getter
    @XmlElement(name = "para")
    private Para p = new Para();

}
