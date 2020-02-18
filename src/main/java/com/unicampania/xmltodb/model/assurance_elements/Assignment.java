package com.unicampania.xmltodb.model.assurance_elements;

import com.unicampania.xmltodb.model.parasequence.Italic;
import com.unicampania.xmltodb.model.parasequence.Xref;
import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Assignment {

    @Getter
    private String id_assignment = new String();

    @Getter
    private String testo;

    @Getter
    @XmlElement(name = "xref")
    private List<Xref> xrefs = new ArrayList<>();

    @Getter
    @XmlElement(name = "italic")
    private List<Italic> italics = new ArrayList<>();
}
