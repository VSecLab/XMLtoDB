package com.unicampania.xmltodb.model.parasequence;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;

public class List {

    @Getter
    @XmlElement(name = "item")
    private java.util.List<Item> items = new ArrayList<>();
}
