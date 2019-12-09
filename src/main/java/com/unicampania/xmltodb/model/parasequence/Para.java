package com.unicampania.xmltodb.model.parasequence;

import com.unicampania.xmltodb.model.parasequence.Bold;
import com.unicampania.xmltodb.model.parasequence.Italic;
import com.unicampania.xmltodb.model.parasequence.Lists;
import com.unicampania.xmltodb.model.parasequence.Xref;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;
import java.util.ArrayList;
import java.util.List;

public class Para {

    @Getter
    @XmlAttribute(name = "type")
    private String type = new String();

    @Getter
    @XmlAttribute(name = "id")
    private String id_para = new String();

    @Getter
    @XmlElement(name = "xref")
    private List<Xref> xrefs = new ArrayList<>();

    @Getter
    @XmlMixed
    private List<String> testo = new ArrayList<>();

    @Getter
    @XmlElement(name = "list")
    private List<Lists> lists = new ArrayList<>();

    @Getter
    @XmlElement(name = "bold")
    private List<Bold> bolds = new ArrayList<>();

    @Getter
    @XmlElement(name = "italic")
    private List<Italic> italics = new ArrayList<>();


    public List<String> getCombo() {
        return merge(testo, xrefs, italics);
    }





    public static List<String> merge(List<String> a, List<Xref> b, List<Italic> c) {

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
            if (c.size() != i && c.size() != 0 && c.size() > i) {
                res.add(c.get(i).toString().replace("[", "").replace("]", "").replaceAll("\r\n", " ").trim());
           }
        }
            return res;

    }
}
