package com.unicampania.xmltodb.config.fclass_preparedstatmentsetter;

import com.unicampania.xmltodb.model.fclass.Fclass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FcoDependenciesPreparedStatmentSetter implements ItemPreparedStatementSetter<Fclass> {
    @Override
    public void setValues(Fclass item, PreparedStatement ps) throws SQLException {

        for (int i = 0; i < item.getFfamilyList().size(); i++) {
            for (int j = 0; j < item.getFfamilyList().get(i).getFComponentList().size(); j++) {
                if (item.getFfamilyList().get(i).getFComponentList().get(j).getFcoDependencies().getFcoDependsoncomponentList().size() == 0) {
                    ps.setString(2, "");
                    ps.setString(3, item.getFfamilyList().get(i).getFComponentList().get(j).getId().toUpperCase());
                } else {
                    for (int k = 0; k < item.getFfamilyList().get(i).getFComponentList().get(j).getFcoDependencies().getFcoDependsoncomponentList().size(); k++) {
                        ps.setString(1, item.getFfamilyList().get(i).getFComponentList().get(j).getId().toUpperCase().concat(item.getFfamilyList().get(i).getFComponentList().get(j).getFcoDependencies().getFcoDependsoncomponentList().get(k).getFcomponent().toUpperCase()));
                        ps.setString(2, item.getFfamilyList().get(i).getFComponentList().get(j).getFcoDependencies().getFcoDependsoncomponentList().get(k).getFcomponent().toUpperCase());
                        ps.setString(3, item.getFfamilyList().get(i).getFComponentList().get(j).getId().toUpperCase());
                        ps.setString(4, item.getFfamilyList().get(i).getFComponentList().get(j).getId().toUpperCase().concat(item.getFfamilyList().get(i).getFComponentList().get(j).getFcoDependencies().getFcoDependsoncomponentList().get(k).getFcomponent().toUpperCase()));
                        ps.addBatch();
                    }
                }
            }

        }

    }
}
