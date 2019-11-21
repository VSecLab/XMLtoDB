package com.unicampania.xmltodb.model.parasequence;

import com.unicampania.xmltodb.model.fclass.Xref;
import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Figure {

    @Getter
    @XmlElement(name = "title")
    private String title;

    @Getter
    @XmlElement(name = "id")
    private String id;
}
