package com.unicampania.xmltodb.model.parasequence.table;


import com.unicampania.xmltodb.model.parasequence.Bold;
import com.unicampania.xmltodb.model.parasequence.Italic;
import com.unicampania.xmltodb.model.parasequence.Lists;
import com.unicampania.xmltodb.model.parasequence.Xref;
import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "footnote")
public class Footnote {

    @Getter
    private String id_footnote;

    @Getter
    @XmlElement
    private String testo;

    @Getter
    @XmlElement(name = "xref")
    private List<Xref> xrefList;

    @Getter
    @XmlElement(name = "list")
    private List<Lists> listsList;

    @Getter
    @XmlElement(name = "bold")
    private List<Bold> boldList;

    @Getter
    @XmlElement(name = "italic")
    private List<Italic> italicList;


}
