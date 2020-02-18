package com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_assurance_paradigm;

import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AClassPreparedStatementSetter implements ItemPreparedStatementSetter<AClass> {


    @Override
    public void setValues(AClass item, PreparedStatement ps) throws SQLException {
        ps.setString(1, item.getId().toUpperCase());
        ps.setString(2, item.getName());
        ps.setString(3, item.getId().toUpperCase());
    }
}





