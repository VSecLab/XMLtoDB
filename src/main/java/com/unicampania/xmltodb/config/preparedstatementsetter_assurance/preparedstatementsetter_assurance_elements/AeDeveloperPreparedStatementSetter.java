package com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_assurance_elements;

import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AeDeveloperPreparedStatementSetter implements ItemPreparedStatementSetter<AClass> {
    @Override
    public void setValues(AClass aClass, PreparedStatement preparedStatement) throws SQLException {
        for (int i = 0; i < aClass.getAFamilies().size(); i++) {
            for (int j = 0; j < aClass.getAFamilies().get(i).getAComponentList().size(); j++) {
                if (aClass.getAFamilies().get(i).getAComponentList().get(j).getAeDeveloperList().size() != 0) {
                    for (int k = 0; k < aClass.getAFamilies().get(i).getAComponentList().get(j).getAeDeveloperList().size(); k++) {
                        preparedStatement.setString(1, aClass.getAFamilies().get(i).getAComponentList().get(j).getAeDeveloperList().get(k).getId_aedeveloper());
                        preparedStatement.setString(2, String.valueOf(aClass.getAFamilies().get(i).getAComponentList().get(j).getAeDeveloperList().get(k).getCombo()).replace("[", "").replace("]", ""));
                        preparedStatement.setString(3, aClass.getId());
                        preparedStatement.setString(4, aClass.getAFamilies().get(i).getId_afamily());
                        preparedStatement.setString(5, aClass.getAFamilies().get(i).getAComponentList().get(j).getId_acomponent());
                        preparedStatement.setString(6, aClass.getAFamilies().get(i).getAComponentList().get(j).getAeDeveloperList().get(k).getId_aedeveloper());
                        preparedStatement.addBatch();
                        preparedStatement.execute();
                    }
                } else {
                    preparedStatement.clearBatch();
                }
            }
        }
    }
}
