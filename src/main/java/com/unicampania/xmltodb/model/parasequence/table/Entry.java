package com.unicampania.xmltodb.model.parasequence.table;


import com.unicampania.xmltodb.model.parasequence.Bold;
import com.unicampania.xmltodb.model.parasequence.Italic;
import com.unicampania.xmltodb.model.parasequence.Xref;
import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "entry")
public class Entry {

    @Getter
    private String id_entry;

    @Getter
    @XmlElement(name = "rowspan")
    private String rowspan;

    @Getter
    @XmlElement(name = "columnspan")
    private String columnspan;

    @Getter
    @XmlElement(name = "width")
    private String width;

    @Getter
    @XmlElement(name = "align")
    private String align;

    @Getter
    @XmlElement(name = "style")
    private String style;

    @Getter
    @XmlElement(name = "xref")
    private List<Xref> xrefList;

    @Getter
    @XmlElement(name = "bold")
    private List<Bold> boldList;

    @Getter
    @XmlElement(name = "italic")
    private List<Italic> italicList;

    @Getter
    @XmlElement(name = "footnote")
    private List<Footnote> footnoteList;




}
