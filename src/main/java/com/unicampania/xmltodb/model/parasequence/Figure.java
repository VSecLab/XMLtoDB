package com.unicampania.xmltodb.model.parasequence;

import com.unicampania.xmltodb.model.fclass.Xref;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Figure {

    @Getter
    @XmlAttribute(name = "id")
    private String id_figure = new String();

    @Getter
    @XmlAttribute(name = "entity")
    private String entity = new String();

    @Getter
    @XmlAttribute(name = "title")
    private String title = new String();

    @Getter
    @XmlAttribute(name = "width")
    private String width = new String();

    @Getter
    @XmlAttribute(name = "height")
    private String height = new String();


}
