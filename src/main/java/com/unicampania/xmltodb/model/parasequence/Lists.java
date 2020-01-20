package com.unicampania.xmltodb.model.parasequence;

import com.unicampania.xmltodb.model.parasequence.Item;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "list")
public class Lists {

    @Getter
    @XmlElement
    private int id_list;

    @Getter
    @XmlAttribute(name = "type")
    private String type = new String();

    @Getter
    @XmlElement(name = "item")
    private List<Item> items = new ArrayList<>();



}
