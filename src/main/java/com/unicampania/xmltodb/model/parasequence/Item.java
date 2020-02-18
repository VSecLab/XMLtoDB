package com.unicampania.xmltodb.model.parasequence;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "item")
public class Item {

    @Getter
    @XmlAttribute(name = "id")
    private String id_item = new String();

    @Getter
    @XmlMixed
    private List<String> testo = new ArrayList<>();

    @Getter
    @XmlElement(name = "list")
    private List<Lists> lists = new ArrayList<>();

    @Getter
    @XmlElement(name = "xref")
    private List<Xref> xrefs = new ArrayList<>();

    @Getter
    @XmlElement(name = "para")
    private List<Para> paras = new ArrayList<>();


    @Getter
    @XmlElement(name = "bold")
    private List<Bold> bolds = new ArrayList<>();

    @Getter
    @XmlElement(name = "bold")
    private Bold bold = new Bold();   //l'ho lasciato perchè mi serve per getBoldItem di Lorenzo

    @Getter
    @XmlElement(name = "italic")
    private List<Italic> italics = new ArrayList<>();



    private List<String> boldItem = new ArrayList<>();

    public List<String> getBoldItem() {
        return getItemBold(testo,bold);
    }

    public List<String> getCombo() {
        return merge(testo, xrefs);
    }

    public static List<String> merge(List<String> a, List<Xref> b) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            res.add(a.get(i).replaceAll("\r\n", " ").trim());
            if (b.size() != i && b.size() != 0) {
                res.add(b.get(i).toString().replace("[", "").replace("]", "").replaceAll("\r\n", " ").trim());
            }
        }
        return res;
    }

    private List<String> getItemBold(List<String> a , Bold b){

        List<String> res = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if(i==0 && b.getTesto() != null) {
                for (int j = 0; j < b.getTesto().size(); j++) {
                    res.add(b.getTesto().get(i));
                }
            }
            res.add(a.get(i).replaceAll("\r\n", " ").trim());
        }
        return res;
    }




    //MIO

    @Getter
    @XmlElement(name = "id")
    private int id;

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
