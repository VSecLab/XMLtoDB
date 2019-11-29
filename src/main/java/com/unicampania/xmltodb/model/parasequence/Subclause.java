package com.unicampania.xmltodb.model.parasequence;


import lombok.Getter;


import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Subclause {

    @Getter
    @XmlElement
    private String id_subclauses = new String();

    @Getter
    @XmlElement
    private List<Subclause> subclauses = new ArrayList<>();

    @Getter
    @XmlElement
    private List<Para> paras = new ArrayList<>();

    @Getter
    @XmlElement
    private List<Figure> figures = new ArrayList<>();

    @Getter
    @XmlElement
    private List<Acronym> acronyms = new ArrayList<>();

    @Getter
    @XmlElement
    private List<Biblioentry> biblioentries = new ArrayList<>();

    @Getter
    @XmlElement
    private List<Glossentry> glossentries = new ArrayList<>();

    @Getter
    @XmlElement
    private List<Table> tables = new ArrayList<>();

    @Getter
    @XmlElement
    private List<Example> examples = new ArrayList<>();

}
