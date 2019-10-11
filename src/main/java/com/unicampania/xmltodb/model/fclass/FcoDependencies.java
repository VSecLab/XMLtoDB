package com.unicampania.xmltodb.model.fclass;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class FcoDependencies {

    @Getter
    @XmlElement(name = "fco-dependsoncomponent")
    private List<FcoDependsoncomponent> fcoDependsoncomponentList = new ArrayList<>();
}
