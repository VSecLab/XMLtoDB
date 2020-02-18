package com.unicampania.xmltodb.model.assurance_component;


import com.unicampania.xmltodb.model.assurance_elements.AeContent;
import com.unicampania.xmltodb.model.assurance_elements.AeDeveloper;
import com.unicampania.xmltodb.model.assurance_elements.AeEvaluator;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class AComponent {

    @Getter
    @XmlAttribute (name = "name")
    private String nome;

    @Getter
    @XmlAttribute(name = "id")
    private String id_acomponent = new String();

    @Getter
    @XmlElement(name = "aco-hierarchical")
    private AcoHierarchical acoHierarchical;

    @Getter
    @XmlElement(name = "aco-dependsoncomponent")
    private List<AcoDependsOnComponent> acoDependsOnComponentList = new ArrayList<>();

    @Getter
    @XmlElement(name = "aco-objectives")
    private AcoObjectives acoObjectives;

    @Getter
    @XmlElement(name = "aco-application-notes")
    private AcoApplicationNotes acoApplicationNotes = new AcoApplicationNotes();

    @Getter
    @XmlElement(name = "msa-objectives")
    private MsaObjectives msaObjectives = new MsaObjectives();

    @Getter
    @XmlElement(name = "msa-application-notes")
    private MsaApplicationNotes msaApplicationNotes;

    @Getter
    @XmlElement(name = "msa-input")
    private MsaInput msaInput;

    @Getter
    @XmlElement(name = "ae-developer")
    private List<AeDeveloper> aeDeveloperList = new ArrayList<>();

    @Getter
    @XmlElement(name = "ae-content")
    private List<AeContent> aeContentList = new ArrayList<>();

    @Getter
    @XmlElement(name = "ae-evaluator")
    private List<AeEvaluator> aeEvaluatorList = new ArrayList<>();
}
