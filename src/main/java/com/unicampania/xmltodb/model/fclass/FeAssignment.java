package com.unicampania.xmltodb.model.fclass;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;

public class FeAssignment {


    @Getter
    @XmlElement(name = "fe-assignmentitem")
    private FeAssignmentitem feAssignmentitem = new FeAssignmentitem();

    @Getter
    @XmlElement(name = "fe-assignmentnotes")
    private FeAssignmentnotes feAssignmentnotes = new FeAssignmentnotes();
}

