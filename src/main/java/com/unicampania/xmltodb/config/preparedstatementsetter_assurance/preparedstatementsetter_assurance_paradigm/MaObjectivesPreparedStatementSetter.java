package com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_assurance_paradigm;

import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MaObjectivesPreparedStatementSetter implements ItemPreparedStatementSetter<AClass> {
    @Override
    public void setValues(AClass item, PreparedStatement ps) throws SQLException {
        ps.setString(1, String.valueOf(Math.random() * 32 * 41));
        ps.setString(2, String.valueOf(item.getMaObjectives().getCombo())
                .replace("[","")
                .replace("]",""));
        ps.setString(3, item.getId().toUpperCase());
        ps.setString(4, String.valueOf(Math.random() * 32 * 41));
    }
}

