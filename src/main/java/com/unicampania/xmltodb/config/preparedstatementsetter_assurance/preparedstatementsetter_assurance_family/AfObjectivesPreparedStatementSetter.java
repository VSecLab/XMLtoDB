package com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_assurance_family;

import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AfObjectivesPreparedStatementSetter implements ItemPreparedStatementSetter<AClass> {
    @Override
    public void setValues(AClass item, PreparedStatement ps) throws SQLException {
        for (int i = 0; i < item.getAFamilies().size(); i++) {
            if (item.getAFamilies().get(i).getAfObjectives() != null) {
                ps.setString(1, String.valueOf(Math.random() * 32 * 41));
                ps.setString(2, String.valueOf(item.getAFamilies().get(i).getAfObjectives().getCombo())
                        .replace("[","")
                        .replace("]",""));
                ps.setString(3, item.getId().toUpperCase());
                ps.setString(4, item.getAFamilies().get(i).getId_afamily());
                ps.setString(5, String.valueOf(Math.random() * 32 * 41));
                ps.addBatch();
                ps.executeBatch();
            } else {
                ps.clearBatch();
            }
        }
    }
}
