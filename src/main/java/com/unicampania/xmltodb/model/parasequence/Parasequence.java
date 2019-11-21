package com.unicampania.xmltodb.model.parasequence;

import com.unicampania.xmltodb.model.fclass.Xref;
import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Parasequence {



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
    @XmlElement(name = "Example")
    private List<Example> examples = new ArrayList<>();

}
