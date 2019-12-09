package com.unicampania.xmltodb.model.parasequence;

import com.unicampania.xmltodb.model.parasequence.Item;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Lists {

    @Getter
    @XmlElement
    private String id_list = new String();

    @Getter
    @XmlAttribute(name = "type")
    private String type = new String();

    @Getter
    @XmlElement(name = "item")
    private List<Item> items = new ArrayList<>();



}
