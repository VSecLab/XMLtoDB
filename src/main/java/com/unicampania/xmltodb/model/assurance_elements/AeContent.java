package com.unicampania.xmltodb.model.assurance_elements;

import com.unicampania.xmltodb.model.parasequence.Xref;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;
import java.util.ArrayList;
import java.util.List;

public class AeContent {

    @Getter
    @XmlAttribute(name = "id")
    private String id_aecontent = new String();

    @Getter
    @XmlMixed
    private List<String> testo = new ArrayList<>();

    @Getter
    @XmlElement(name = "xref")
    private List<Xref> xrefList = new ArrayList<>();

    public List<String> getCombo() {
        return merge(testo, xrefList);
    }

    public static List<String> merge(List<String> a, List<Xref> b) {

        List<String> res = new ArrayList<>();
        if(a.size() == 1 ){
            res.add(a.get(0));
            return  res ;
        }
        for (int i = 0; i < a.size(); i++) {

            res.add(a.get(i).replaceAll("\r\n", " ").trim());
            if (b.size() != i && b.size() != 0 && b.size() > i) {
                res.add(b.get(i).toString().replace("[", "").replace("]", "").replaceAll("\r\n", " ").trim());
            }
        }
        return res;
    }
}
