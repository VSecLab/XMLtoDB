package com.unicampania.xmltodb.model.fclass;

import lombok.Getter;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class FcoUserNotes {

    @Getter
    @XmlElement(name = "para")
    private List<Para> p = new ArrayList<>();
}