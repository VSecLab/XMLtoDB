package com.unicampania.xmltodb.model.parasequence;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;
import java.util.ArrayList;
import java.util.List;

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

    @Getter
    @XmlElement(name = "selection")
    private List<Selection> selections = new ArrayList<>();

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
                res.add(b.getTesto());
            }
            res.add(a.get(i).replaceAll("\r\n", " ").trim());

        }

        return res;
    }
}
