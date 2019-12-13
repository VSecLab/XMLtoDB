package com.unicampania.xmltodb.model.parasequence;


import com.unicampania.xmltodb.model.parasequence.table.Table;
import lombok.Getter;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Subclause {

    @Getter
    @XmlAttribute(name = "id")
    private String id_subclauses = new String();

    @Getter
    @XmlAttribute(name = "title")
    private String title= new String();


    @Getter
    @XmlElement(name = "subclause")
    private List<Subclause> subclauses = new ArrayList<>();

    @Getter
    @XmlElement(name = "para")
    private List<Para> paras = new ArrayList<>();

    @Getter
    @XmlElement(name = "figure")
    private List<Figure> figures = new ArrayList<>();

    @Getter
    @XmlElement(name = "acronym")
    private List<Acronym> acronyms = new ArrayList<>();

    @Getter
    @XmlElement(name = "biblioentry")
    private List<Biblioentry> biblioentries = new ArrayList<>();

    @Getter
    @XmlElement(name = "glossentry")
    private List<Glossentry> glossentries = new ArrayList<>();

    @Getter
    @XmlElement(name = "table")
    private List<Table> tables = new ArrayList<>();

    @Getter
    @XmlElement(name ="example")  //non ho capito se è attribute o element
    private List<Example> examples = new ArrayList<>();

}


