package com.unicampania.xmltodb.config.aclass_preparedstatmentsetter;

import com.unicampania.xmltodb.model.aclass.AClass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AClassPreparedStatmentSetter implements ItemPreparedStatementSetter<AClass> {


    @Override
    public void setValues(AClass item, PreparedStatement ps) throws SQLException {
        ps.setString(1, item.getId());
        ps.setString(2, item.getName());
    }
}





