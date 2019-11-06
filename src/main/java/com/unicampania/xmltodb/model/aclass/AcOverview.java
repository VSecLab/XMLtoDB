package com.unicampania.xmltodb.model.aclass;

import com.unicampania.xmltodb.model.fclass.Para;
import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class AcOverview {

    @Getter
    @XmlElement(name = "para")
    private List<Para> p = new ArrayList<>();

}
