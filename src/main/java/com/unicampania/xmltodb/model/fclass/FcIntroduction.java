package com.unicampania.xmltodb.model.fclass;

import com.unicampania.xmltodb.model.parasequence.Para;
import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class FcIntroduction {


    @Getter
    @XmlElement(name = "para")
    private List<Para> p = new ArrayList<>();


}
