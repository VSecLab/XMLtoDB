package com.unicampania.xmltodb.model.parasequence;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "italic")
public class Italic {

    @Getter
    @XmlElement
    private int id_italic;

    @Getter
    @XmlMixed
    private List<String> testo = new ArrayList<>();

    @Getter
    @XmlElement(name = "xref")
    private List<Xref> xrefs = new ArrayList<>();

    @Getter
    @XmlElement(name = "bold")
    private List<Bold> bolds = new ArrayList<>();


    public static List<String> getTesto(List<String> testo) {
        List<String> text = new ArrayList<>();
        if (testo.size() == 1) {
            text.add(testo.get(0));
            return text;
        } else {
            for (int i = 0; i < testo.size(); i++) {
                text.add(testo.get(i));
            }
        }
        return  text;

    }

}
