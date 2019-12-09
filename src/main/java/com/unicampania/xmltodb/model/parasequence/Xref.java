package com.unicampania.xmltodb.model.parasequence;

import lombok.Getter;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Xref {


    @Getter
    @XmlAttribute(name = "show")
    private String show = new String();

    @Getter
    @XmlAttribute(name = "id")
    private String id_xref = new String();

    @Override
    public String toString() {
        return  id_xref.toUpperCase().replaceAll ("\r\n", " ").trim() + " " ;
    }

}
