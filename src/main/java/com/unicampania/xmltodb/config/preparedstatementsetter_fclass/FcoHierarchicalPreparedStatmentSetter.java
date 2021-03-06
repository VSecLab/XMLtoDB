package com.unicampania.xmltodb.config.preparedstatementsetter_fclass;

import com.unicampania.xmltodb.model.fclass.Fclass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FcoHierarchicalPreparedStatmentSetter implements ItemPreparedStatementSetter<Fclass> {

    @Override
    public void setValues(Fclass item, PreparedStatement ps) throws SQLException {

        for (int i = 0; i < item.getFfamilyList().size(); i++) {

            for (int j = 0; j < item.getFfamilyList().get(i).getFComponentList().size(); j++) {
                if (item.getFfamilyList().get(i).getFComponentList().get(j).getFcoHierarchical().getFcomponent() == null) {
                    ps.setString(1, "");
                    ps.setString(2, item.getFfamilyList().get(i).getFComponentList().get(j).getId().toUpperCase());
                    ps.setString(3, "");
                } else {
                    ps.setString(1, item.getFfamilyList().get(i).getFComponentList().get(j).getFcoHierarchical().getFcomponent().toUpperCase());
                    ps.setString(2, item.getFfamilyList().get(i).getFComponentList().get(j).getId().toUpperCase());
                    ps.setString(3, item.getFfamilyList().get(i).getFComponentList().get(j).getFcoHierarchical().getFcomponent().toUpperCase());
                    ps.addBatch();
                }
            }
        }
    }
}
